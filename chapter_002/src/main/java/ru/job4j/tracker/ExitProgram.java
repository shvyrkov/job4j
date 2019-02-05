package ru.job4j.tracker;

/**
 * Реализация интерфейса UserAction для выхода из программы.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.05
 */
public class ExitProgram implements UserAction {
    /**
     * Метод возвращает ключ опции EXIT.
     *
     * @return ключ EXIT = 6
     */
    @Override
    public int key() {
        return 6;
    }

    /**
     * Переопределение основного метода execute для выхода из программы.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
		System.out.println();
        String id = input.ask("Exit Program? y/n : ");
        
    }

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню: " 6. Exit Program."
     */
    @Override
    public String info() {
        return "6. Exit Program.";
    }
}
