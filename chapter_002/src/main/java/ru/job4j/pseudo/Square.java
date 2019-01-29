package ru.job4j.pseudo;

/**
 * Класс Square - программа реализации интерфейса Shape для квадрата.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.29
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++");
		pic.append(System.lineSeparator());
        pic.append("+   +");
		pic.append(System.lineSeparator());
        pic.append("+   +");
		pic.append(System.lineSeparator());
        pic.append("+++++");
        return pic.toString();
    }
}