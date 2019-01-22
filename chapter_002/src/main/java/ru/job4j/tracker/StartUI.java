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
            String answer = this.input.ask("Введите пункт меню : ");
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
        System.out.println("------------ Добавление новой заявки -------------");
        String name = this.input.ask("Введите имя заявки :  ");
        String desc = this.input.ask("Введите описание заявки :  ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("-------- Новая заявка с Id: " + item.getId() + " --------");
    }

    /**
     * Метод реализует вывод на экран всех заявок.
     */
    private void showAll() {
        System.out.println("----------------- Список заявок ------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("   Id           |   Имя      |   Описание         ");
        System.out.println("--------------------------------------------------");
        for (Item item : this.tracker.findAll()) {
            if (item != null) {
                System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("----------------- Конец списка -------------------");
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки ---------------");
        String id = this.input.ask("Введите Id заявки : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Имя      |   Описание         ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
            String name = this.input.ask("Введите новое имя заявки : ");
            String desc = this.input.ask("Введите новое описание заявки : ");
            Item newItem = new Item(name, desc);
            newItem.setId(id);
            this.tracker.replace(id, newItem);
            System.out.println("Заявка с Id : " + item.getId() + " была изменена");
        } else {
            System.out.println("Заявка с id: " + id + "  отсутствует в базе данных.");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("--------------- Удаление заявки ---------------");
        String id = this.input.ask("Введите Id заявки : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Имя      |   Описание         ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
            String answer = this.input.ask("Удалить? Y/N : ");
            if (answer.equals("Y")) {
                this.tracker.delete(id);
                System.out.println("----- Заявка удалена -----");
            }
        } else {
            System.out.println("Заявка с id: " + id + "  отсутствует в базе данных.");
        }
    }

    /**
     * Метод реализует поиск заявки по Id.
     */
    private void findId() {
        String id = this.input.ask("Введите Id заявки : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Имя      |   Описание         ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("Заявка с id: " + id + "  отсутствует в базе данных.");
        }
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findName() {
        String name = this.input.ask("Введите имя заявки : ");
        if (this.tracker.findByName(name)[0] == null) {
            System.out.println("Заявки с Именем: '" + name + "' отсутствуют в базе данных.");
            return;
        }
        System.out.println("-------- Список заявок с именем '" + name + "'---------");
        System.out.println("--------------------------------------------------");
        System.out.println("   Id           |   Имя      |   Описание         ");
        System.out.println("--------------------------------------------------");
        for (Item item : this.tracker.findByName(name)) {
            if (item != null) {
                System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("----------------- Конец списка -------------------");
    }

    private void showMenu() {
        System.out.println("       Меню.");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по id");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выход из программы");
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
