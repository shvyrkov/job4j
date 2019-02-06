package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для вывода на экран полного списка заявок пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
 */
public class FindAllItem implements UserAction {
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOWALL = "1";

    /**
     * Метод возвращает ключ опции SHOWALL.
     *
     * @return ключ SHOWALL = 1
     */
    @Override
    public int key() {
        return Integer.valueOf(SHOWALL);
    }

    /**
     * Переопределение основного метода execute на вывод на экран полного списка заявок.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
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

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню: "1. Show all items."
     */
    @Override
    public String info() {
        return SHOWALL + ". Show all Items.";
    }
}
