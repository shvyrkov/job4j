package ru.job4j.tracker;

/**
 * Класс LoadOrder - тестовая программа для печати  статических/нестатических элементов.
 * Порядок загрузки элементов.
 * 1. Статические поля.
 * 2. Статические блоки.
 * 3. Не статические блоки.
 * 4. Не статические поля.
 * 5. Конструктор.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.12.29
 */
public class LoadOrder {

    private static String staticfield = echo("static field");

    private static final String STATIC_FINAL_FIELD = echo("static final field");

    {
        echo("not-static block");
    }

    static {
        echo("static block");
    }

    private String surname = echo("field");

    private final String name = echo("final field");

    public LoadOrder(String msg) {
        echo("constructor " + msg);
    }

    public static String echo(String text) {
        System.out.println(text);
        return text;
    }

    private static final class Holder {
        private static final LoadOrder INSTANCE = new LoadOrder("static inner field");
    }

    public static void main(String[] args) {
        LoadOrder order = new LoadOrder("main");
    }
}
