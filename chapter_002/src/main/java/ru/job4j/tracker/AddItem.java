package ru.job4j.tracker;

import java.lang.*;

/**
 * Реализация интерфейса UserAction для добавления новой заявки пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.1
 * @since 2019.02.03
 */
public class AddItem extends BaseAction {

    /**
     * Конструтор инициализирующий поля.
     *
     * @param key - номер меню.
     * @param name - названия номера меню.
     */
	public AddItem(int key, String name) {
        super(key, name);
	}

    /**
     * Переопределение основного метода execute на добавление заявки.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDesc());
    }
}