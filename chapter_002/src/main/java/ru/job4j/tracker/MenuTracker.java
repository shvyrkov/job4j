package ru.job4j.tracker;

import java.util.*;

/**
 * Класс MenuTracker - для работы пользователя с меню.
 *
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
     * Объявление списочного массива actions типа UserAction для действий пользователя.
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
     *
     * @param ui - объект типа StartUI для  передачи в ExitProgram
     */
    public void fillActions(StartUI ui) {
        this.actions.add(0, new AddItem(0, "Add new Item")); // Метод .add из ArrayList - добавление эл-та в массив.
        this.actions.add(1, new FindAllItem(1, "Show all Items")); // 1, - индекс эл-та в массиве.
        this.actions.add(2, new UpdateItem(2, "Edit Item")); // Содержимое эл-та - объект типа UpdateItem().
        this.actions.add(3, new DeleteItem(3, "Delete Item"));
        this.actions.add(4, new FindItemById(4, "Find Item by Id"));
        this.actions.add(5, new FindByNameItem(5, "Find Items by Name"));
        this.actions.add(6, new ExitProgram(ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующее действие, т.е. ввод пользователам номера из меню.
     *
     * @param key ключ операции
     */
    public void select(int key) { // Обращение к эл-ту с индексом key и выполнение соотвествующего execute.
        this.actions.get(key).execute(this.input, this.tracker); // Метод .get из ArrayList извлекает эл-т из ячейки с номером key.
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

    /**
     * Метод для получения диапазона допустимых значений для ввода пользователем.
     *
     * @return - range - массив допустимых значений для ввода пользователем.
     */
    public int[] range() {
        int[] range = new int[this.actions.size()];
        for (int i = 0; i < range.length; i++) {
            if (this.actions.get(i) != null) {
                range[i] = i;
            }
        }
        return range;
    }
}
