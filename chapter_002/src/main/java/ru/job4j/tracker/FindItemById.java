package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для поиска заявки по Id.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.05
 */
public class FindItemById implements UserAction {

    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";

    /**
     * Метод возвращает ключ опции FINDBYID.
     *
     * @return ключ FINDBYID = 4
     */
    @Override
    public int key() {
        return Integer.valueOf(FINDBYID);
    }

    /**
     * Переопределение основного метода execute для поиска заявки по Id.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println();
        String id = input.ask("Enter Id of Item : ");
        Item item = tracker.findById(id);
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
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню: "4. Find item by Id"
     */
    @Override
    public String info() {
        return FINDBYID + ". Find Item by Id.";
    }
}
