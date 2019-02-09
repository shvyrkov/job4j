package ru.job4j.tracker;

import java.util.*;

/**
 * Класс ValidateInput - подкласс от ConsoleInput для проверки вводимых пользователем данных.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.09
 */
public class ValidateInput extends ConsoleInput {

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
                value = super.ask(question, range); // Запрос ввода через суперкласс ConsoleInput.
                invalid = false; // Если ввод правильный - выход из цикла.
            } catch (MenuOutException moe) { // Если введен некорректный номер меню (тип int). Получается из Consolenput.
                System.out.println("Please, select key from menu.");
            } catch (NumberFormatException nfe) { //  Если введен параметр не типа int. Выдается JVM.
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}