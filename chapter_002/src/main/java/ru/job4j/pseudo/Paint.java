package ru.job4j.pseudo;

/**
 * Класс Paint - вывод информации в консоль.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.29
 */

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}