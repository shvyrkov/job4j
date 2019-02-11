package ru.job4j.tracker;

import java.util.*;

/**
 * Класс ConsoleInput - программа реализации методов интерфейса Input для общения с пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.16
 */
public class ConsoleInput implements Input {

    /**
     * Поле для ввода данных с клавиатуры.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метода ask для диалога с пользователем.
     *
     * @param - question - вопрос выводимый на экран.
     * @return - символы введённые пользователем.
     */
    public String ask(String question) {
        System.out.print(question); // Вывод вопроса на экран.
        return scanner.nextLine(); // Считывание и возврат введенного значения.
    }

    /**
     * Переопределение метода ask для диалога с пользователем.
     *
     * @param - question - вопрос выводимый на экран.
     * @param - range - диапазон допустимых значений для ввода пользователем.
     * @return - exist - либо правильный номер меню введённый пользователем, либо исключение MenuOutException.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question)); // Использует 1-й метод ask для ввода данных.
        // Автогенерация (by JVM) исключения NFE при вводе данных не типа int.
        boolean exist = false;
        for (int value : range) { // Сравнение введенного значения с заданным диапазоном.
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range."); // Генерация исключения при выходе за границы массива.
        }
        return key;
    }
}