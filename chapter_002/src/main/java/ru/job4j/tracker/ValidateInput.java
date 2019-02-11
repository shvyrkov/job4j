package ru.job4j.tracker;

import java.util.*;

/**
 * Класс ValidateInput - реализация интерфейса Input для проверки вводимых пользователем данных.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.09
 */
public class ValidateInput implements Input {

    /**
     * Поле - источник данных.
     */
    private final Input input;

    /**
     * Конструктор для ввода данных, input - к-л. реализация интерфейса Input (ConsoleInput или StubInput).
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Метода ask будет запрашиваться через к-л. реализацию интерфейса Input (ConsoleInput или StubInput).
     *
     * @param - question - вопрос выводимый на экран.
     * @return - символы введённые пользователем.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Переопределение метода ask для диалога с пользователем.
     *
     * @param - question - вопрос выводимый на экран.
     * @param - range - диапазон допустимых значений для ввода пользователем.
     * @return - value - правильный номер меню введённый пользователем.
     */
    public int ask(String question, int[] range) {

        boolean invalid = true; // Переменная неправильного ввода.
        int value = -1;

        do {
            try {
                value = this.input.ask(question, range); // Запрос ввода через объект input типа Input.
                invalid = false; // Если ввод правильный - выход из цикла.
            } catch (MenuOutException moe) { // Если введен некорректный номер меню (тип int).
                System.out.println("Please, select key from menu.");
            } catch (NumberFormatException nfe) { //  Если введен параметр не типа int. Выдается JVM.
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}