package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для вывода на экран списка заявок с именем, заданным пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
 */
public class FindByNameItem extends BaseAction {

    /**
     * Конструтор инициализирующий поля.
     *
     * @param key - номер меню.
     * @param name - названия номера меню.
     */
	public FindByNameItem(int key, String name) {
        super(key, name);
	}


    /**
     * Переопределение основного execute метода на вывод на экран списка заявок с указанным именем.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println();
        String name = input.ask("Enter Name of Item : ");
        if (tracker.findByName(name)[0] == null) {
            System.out.println("--- Item with Name: '" + name + "' is missing in Tracker. ---");
            return;
        }
        System.out.println("-------- List of Items with Name '" + name + "'---------");
        System.out.println("--------------------------------------------------");
        System.out.println("   Id           |   Name      |   Description     ");
        System.out.println("--------------------------------------------------");
        for (Item item : tracker.findByName(name)) {
            if (item != null) {
                System.out.println(" " + item.getId() + "  |  " + item.getName() + "  |  " + item.getDesc());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("----------------- End of list --------------------");
    }
}
