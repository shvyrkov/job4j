package ru.job4j.tracker;

/**
 * Класс StartUI - программа общения с пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.16
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOWALL = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   - ввод данных.
     * @param tracker - хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter Menu item : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findId();
            } else if (FINDBYNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
		System.out.println();
        System.out.println("------------ Add new Item -------------");
        String name = this.input.ask("Name :  ");
        String desc = this.input.ask("Description :  ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("--- New Item with Id: " + item.getId() + " ---");
    }

    /**
     * Метод реализует вывод на экран всех заявок.
     */
    private void showAll() {
		System.out.println();
        System.out.println("--------------- List of all Items ----------------");
        System.out.println("--------------------------------------------------");
        System.out.println("   Id           |   Name      |   Description     ");
        System.out.println("--------------------------------------------------");
        for (Item item : this.tracker.findAll()) {
            if (item != null) {
                System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("----------------- End of list -------------------");
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
		System.out.println();
        System.out.println("------------ Edit Item ---------------");
        String id = this.input.ask("Enter Item's Id : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Name      |   Description     ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
            String name = this.input.ask("Enter new Name of Item : ");
            String desc = this.input.ask("Enter new Description of Item : ");
            Item newItem = new Item(name, desc);
            newItem.setId(id);
            this.tracker.replace(id, newItem);
            System.out.println("--- Item with Id : " + item.getId() + " has been changed. ---");
        } else {
            System.out.println("--- Item with Id: '" + id + "' is missing in Tracker. ---");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
		System.out.println();
        System.out.println("--------------- Delete Item ---------------");
        String id = this.input.ask("Enter Id of Item : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Name      |   Description     ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
            String answer = this.input.ask("Delete Item? Y/N : ");
            if (answer.equals("Y")) {
                this.tracker.delete(id);
                System.out.println("--- Item with Id : '" + item.getId() + "' has been deleted. ---");
            }
        } else {
            System.out.println("--- Item with Id: '" + id + "' is missing in Tracker. ---");
        }
    }

    /**
     * Метод реализует поиск заявки по Id.
     */
    private void findId() {
		System.out.println();
        String id = this.input.ask("Enter Id of Item : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Name      |   Description     ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--- Item with Id: '" + id + "' is missing in Tracker. ---");
        }
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findName() {
		System.out.println();
        String name = this.input.ask("Enter Name of Item : ");
        if (this.tracker.findByName(name)[0] == null) {
            System.out.println("--- Item with Name: '" + name + "' is missing in Tracker. ---");
            return;
        }
        System.out.println("-------- List of Items with Name '" + name + "'---------");
        System.out.println("--------------------------------------------------");
        System.out.println("   Id           |   Name      |   Description     ");
        System.out.println("--------------------------------------------------");
        for (Item item : this.tracker.findByName(name)) {
            if (item != null) {
                System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("----------------- End of list -------------------");
    }

    private void showMenu() {
		System.out.println();
        System.out.println("       Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. List of all Items");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Find Item by Id");
        System.out.println("5. Find Item by Name");
        System.out.println("6. Exit");
		System.out.println();
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
