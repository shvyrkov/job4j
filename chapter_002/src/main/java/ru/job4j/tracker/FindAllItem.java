package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для вывода на экран полного списка заявок пользователем.
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
*/
public class FindAllItem implements UserAction {
    @Override
    public int key() {
        return SHOWALL;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("--------------- List of all Items ----------------");
        System.out.println("--------------------------------------------------");
        System.out.println("   Id           |   Name      |   Description     ");
        System.out.println("--------------------------------------------------");
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("----------------- End of list --------------------");
    }

    @Override
    public String info() {
        return "Show all items.";
    }
}
