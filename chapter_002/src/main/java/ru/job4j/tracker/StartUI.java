package ru.job4j.tracker;

/**
 * Класс StartUI - программа общения с пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.1
 * @since 2019.01.16
 */
public class StartUI {

    /**
     * Переменная для выхода из цикла.
     */
    private boolean work = true;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   - ввод данных.
     * @param tracker - хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this); // Заполнение массива действий пользователя , this - т.к. мы внутри класса StartUI.
        do {
            menu.show(); // Вывод меню на экран.
            menu.select(Integer.valueOf(input.ask("Select:", menu.range()))); // Вывод на экран "Select:" c преобразованием типа в Integer введенного пользователем значения типа String.
        }
        while (work);
        //       while (!"y".equals(this.input.ask("Exit?(y): "))); // Вывод на экран "Exit?(y): ", если "y" - выход из программы.
    }

    /**
     * Метод для выхода из программы.
     */
    public void stop() {
        this.work = false;
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
