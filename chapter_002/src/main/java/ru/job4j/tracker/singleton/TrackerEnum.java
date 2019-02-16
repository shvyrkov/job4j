package ru.job4j.tracker.singleton;

import java.util.*;

import ru.job4j.tracker.*;

/**
 * Класс TrackerEnum - Singleton-реализация хранилища для заявок.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.14
 */
public enum TrackerEnum {
    INSTANCE;

    /**
     * Массив items для хранение заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки position для новой заявки.
     */
    private int position = 0;

    /**
     * Объект RN для генерации случайного числа.
     */
    private static final Random RN = new Random();

    /**
     * Метод add() реализаущий добавление заявки в хранилище с уникальным id.
     *
     * @param item - новая заявка.
     * @return item - новая заявка занесенная в массив заявок items в ячейку с номером position.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод generateId() генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания. Для идентификации заявки нужен уникальный ключ.
     *
     * @return - Уникальный ключ (текущее время в милисекундах+случайное_целое_число).
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод replace() заменяет ячейку в массиве this.items.
     * Поиск ячейки в массиве происходит по id.
     *
     * @param id   - уникальный id заявки, которую надо заменить.
     * @param item - новая заявка.
     * @return - true, если удалось провести операцию.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                this.items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод delete() удаляет ячейку в массиве this.items.
     * Поиск ячейки в массиве происходит по id.
     * Далее смещает все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy().
     *
     * @param id - уникальный id заявки.
     * @return - true, если удалось ли провести операцию.
     */
    public boolean delete(String id) {
        boolean result = false;
        //Получение индекса ячейки, подлежащей удалению.
        int index = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                index = i;
            }
        }
        System.arraycopy(this.items, index + 1, this.items, index, position - index + 1);
        this.position--;
        return result;
    }

    /**
     * Метод findAll() возвращает копию массива this.items без null элементов.
     *
     * @return - копия массива this.items без null элементов.
     */
    public Item[] findAll() {
        Item[] copyItems = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            copyItems[index] = this.items[index];
        }
        return copyItems;
    }

    /**
     * Метод findByName() осуществляет поиск заявок по имени (name).
     * проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     *
     * @param key - имя для поиска.
     * @return - keyName[] - результирующий массив.
     */
    public Item[] findByName(String key) {
        Item[] keyName = new Item[this.position];
        int index = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                keyName[index++] = item;
            }
        }
        return keyName;
    }

    /**
     * Метод findById() осуществляет поиск заявки по id.
     *
     * @param id - уникальный id заявки.
     * @return - заявка с заданным id, если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TrackerEnum tracker = new TrackerEnum();
    }
}


