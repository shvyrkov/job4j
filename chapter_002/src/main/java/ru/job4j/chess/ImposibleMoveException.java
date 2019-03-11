package ru.job4j.chess;

/**
 * Класс ImposibleMoveException - исключение для неправильного хода фигуры.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.03.11
 */

public class ImposibleMoveException extends RuntimeException {
	// Конструктор принимает сообщение об ошибке и передает его в родительский класс.
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}