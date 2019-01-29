package ru.job4j.pseudo;

/**
 * Класс Triangle - программа реализации интерфейса Shape для треугольника.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.29
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   0   ");
		pic.append(System.lineSeparator());
        pic.append("  000  ");
		pic.append(System.lineSeparator());
        pic.append(" 00000 ");
		pic.append(System.lineSeparator());
        pic.append("0000000");
        return pic.toString();
    }
}