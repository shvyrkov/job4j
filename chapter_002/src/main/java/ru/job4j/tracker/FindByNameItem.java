package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для вывода на экран списка заявок с именем, заданным пользователем.
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
*/
public class FindByNameItem implements UserAction {
    @Override
    public int key() {
        return FINDBYNAME;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
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
        System.out.println("----------------- End of list --------------------");
    }

    @Override
    public String info() {
        return "Find items by name.";
    }
}
