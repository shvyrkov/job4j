package ru.job4j.tracker;

/**
 * Класс MenuOutException - исключение для данных вводимых пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.09
 */
public class MenuOutException extends RuntimeException {

    // Конструктор принимает сообщение об ошибке и передает его в родительский класс.
    MenuOutException(String msg) {
        super(msg);
    }
}