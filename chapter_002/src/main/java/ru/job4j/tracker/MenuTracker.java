package ru.job4j.tracker;

import java.util.*;
/**
 * Класс MenuTracker - для работы пользователя с меню.
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.03
*/
public class MenuTracker {
    /**
     * @param input - хранит ссылку на объект типа Input.
     */
    private Input input;
    /**
     * @param tracker - хранит ссылку на объект типа Tracker.
     */
    private Tracker tracker;
    /**
     * Объявление списочного массива actions типа UserAction
     *
     * @param хранит ссылку на массив типа UserAction. ??
     */
    private List<UserAction> actions = new ArrayList<>(); // Почему List, а не ArrayList?

    /**
     * Конструктор.
     *
     * @param input   - объект типа Input
     * @param tracker - объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения длины массива меню.
     *
     * @return длина массива
     */
    public int getActionsLentgh() {
        return this.actions.size(); // Метод .size из ArrayList - возвращает длину списочного массива.
    }

    /**
     * Метод заполняет массив содержимого меню.
     */
     public void fillActions() {
        this.actions.add(new AddItem(0, "Add program")); // Метод .add из ArrayList - добавление эл-та в массив.
        this.actions.add(new FindAllItem(1, "Show all items")); // 1, - индекс эл-та в массиве.
        this.actions.add(new UpdateItem(2, "Edit item")); // "Edit item" - содержимое эл-та.
        this.actions.add(new DeleteItem(3, "Delete item"));
//        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindByNameItem(5, "Find items by name"));
//        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующее действие, т.е. ввод пользователам номера из меню.
     *
     * @param key ключ операции
     */
    public void select(int key) { // Обращение к эл-ту с индексом key и выполнение соотвествующего execute.
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
