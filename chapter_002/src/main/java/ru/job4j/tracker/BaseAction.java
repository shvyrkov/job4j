package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction в абстрактном классе BaseAction для общих методов.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.12
 */
public abstract class BaseAction implements UserAction {
	
	/**
     * Поле для номера меню.
     */
    private final int key;
	
	/**
     * Поле для названия номера меню.
     */	
    private final String name;
	
    /**
     * Конструтор инициализирующий поля.
     *
     * @param key - номер меню.
     * @param name - названия номера меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
	
    /**
     * Метод возвращает ключ опции меню.
     *
     * @return - key - номер меню.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Метод возвращает информацию о пункте меню.
     *
     * @return - Строка меню: "Номер_меню. Содержимое пункта меню."
     */
    @Override
    public String info() {
        return String.format("%s. %s.", this.key, this.name);
    }
}
