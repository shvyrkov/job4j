package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TriangleTest - программа тестирования для Square (реализация интерфейса Shape для треугольника).
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.29
 */

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
		//System.out.println(triangle.draw());
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   0   ")
								.append(System.lineSeparator())
                                .append("  000  ")
								.append(System.lineSeparator())
                                .append(" 00000 ")
								.append(System.lineSeparator())
                                .append("0000000")
                                .toString()
                )
        );
    }
}