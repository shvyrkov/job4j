package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Класс ValidateInputTest - для тестирования StartUI (эмуляция действий пользователя).
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Тест для проверки работы NumberFormatException.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"})); // "invalid" - ввод не типа int.
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter validate data again.%n")
                )
        );
    }

    /**
     * Тест для проверки работы MenuOutException.
     */
    @Test
    public void whenInvalidMenuNumber() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", "0"}) // "2" - неправильный номер меню, "0" - правильный номер для выхода из теста.
        );
        input.ask("Enter", new int[]{0}); // {0} - правильный номер меню.
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, select key from menu.%n")
                )
        );
    }

    /**
     * Тест для проверки работы при правильном вводе.
     */
    @Test
    public void whenInputCorrect() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"3"}) // "3" - введенный номер меню.
        );
        input.ask("Enter", new int[]{3}); // {3} - допустимое значение ввода.
        assertThat(
                this.mem.toString(),
                is(
                        String.format("")
                )
        );
    }
}
