package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для редактирования заявки пользователем.
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
*/
public class UpdateItem implements UserAction {
    @Override
    public int key() {
        return EDIT;
    }

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

    @Override
    public String info() {
        return "Edit Item.";
    }
}
