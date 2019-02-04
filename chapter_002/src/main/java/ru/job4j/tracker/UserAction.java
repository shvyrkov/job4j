package ru.job4j.tracker;

/**
 * Интерфейс для описания действий пользователя.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
 */
public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     *
     * @param input   - объект типа Input
     * @param tracker - объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    String info();
}