package ru.job4j.tracker;

/**
 * Класс Input - программа интерфейса общения с пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.16
 */
public interface Input {
    String ask(String question);
	int ask(String question, int[] range);
}