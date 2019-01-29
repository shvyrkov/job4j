package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс SquareTest - программа тестирования для Square (реализация интерфейса Shape для квадрата).
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.29
 */

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        //System.out.println(square.draw());
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("+++++")
								.append(System.lineSeparator())
                                .append("+   +")
								.append(System.lineSeparator())
                                .append("+   +")
								.append(System.lineSeparator())
                                .append("+++++")
								.toString()
                )
        );
    }
}