package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для удаления заявки пользователем.
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
*/
public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return DELETE;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
		String id = input.ask("Please, enter item's id : ");
		Item item = tracker.findById(id);
        if (item != null) {
			System.out.println("--------------------------------------------------");
            System.out.println("   Id           |   Name      |   Description     ");
            System.out.println("--------------------------------------------------");
            System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
            System.out.println("--------------------------------------------------");
            String answer = this.input.ask("Delete Item? y/n : ");
            if (answer.equals("y")) {
                this.tracker.delete(id);
                System.out.println("--- Item with Id : '" + item.getId() + "' has been deleted. ---");
            }
        } else {
            System.out.println("--- Item with Id: '" + id + "' is missing in Tracker. ---");
        }
    }

    @Override
    public String info() {
        return "Delete item.";
    }
}
