package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс PaintTest - программа тестирования для Paint (вывод информации в консоль).
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.1 Рефакторинг
 * @since 2019.01.29
 */

public class PaintTest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before // Выполняется перед каждым тестом.
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After // Выполняется после каждого теста.
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест для квадрата.
     */
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        // PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        // ByteArrayOutputStream out = new ByteArrayOutputStream();
        // Заменяем стандартный вывод на вывод в пямять для тестирования.
        // System.setOut(new PrintStream(out));
        // выполняем действия пишушие в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+++++")
                                .append(System.lineSeparator())
                                .append("+   +")
                                .append(System.lineSeparator())
                                .append("+   +")
                                .append(System.lineSeparator())
                                .append("+++++")
                                .append(System.lineSeparator()) // !!!
                                .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        // System.setOut(stdout);
    }

    /**
     * Тест для треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   0   ")
                                .append(System.lineSeparator())
                                .append("  000  ")
                                .append(System.lineSeparator())
                                .append(" 00000 ")
                                .append(System.lineSeparator())
                                .append("0000000")
                                .append(System.lineSeparator()) // !!!
                                .toString()
                )
        );
    }
}