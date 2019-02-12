package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для редактирования заявки пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
 */
public class UpdateItem extends BaseAction {

    /**
     * Конструтор инициализирующий поля.
     *
     * @param key - номер меню.
     * @param name - названия номера меню.
     */
	public UpdateItem(int key, String name) {
        super(key, name);
	}

    /**
     * Переопределение основного метода execute на редактирование заявки.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Update item --------------");
        String id = input.ask("Please, enter item's id : ");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.ask("Please, provide new item name:");
            String desc = input.ask("Please, provide new item description:");

            Item newItem = new Item(name, desc);
            newItem.setId(id);
            tracker.replace(id, newItem);
            System.out.println("------------ Item with Id : " + item.getId() + " has been changed. ---");
            System.out.println("------------ New Item's Name : " + item.getName());
            System.out.println("------------ New Item's Description : " + item.getDesc());
        } else {
            System.out.println("--- Item with Id: '" + id + "' is missing in Tracker. ---");
        }
    }
}
