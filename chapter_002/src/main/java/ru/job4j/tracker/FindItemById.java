package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для поиска заявки по Id.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.05
 */
public class FindItemById extends BaseAction {

    /**
     * Конструтор инициализирующий поля.
     *
     * @param key - номер меню.
     * @param name - названия номера меню.
     */
	public FindItemById(int key, String name) {
        super(key, name);
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
}
