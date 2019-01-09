package ru.job4j.tracker;

import java.util.*;//for Random

/**
 * Класс Tracker - хранилище для заявок.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.12.29
 */
public class Tracker {
    /**
     * Массив items для хранение заявок.
     */
    private final Item[] items = new Item[100];

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
		return String.valueOf(System.currentTimeMillis()+RN.nextInt());
    }
	
	/**
     * Метод replace() заменяет ячейку в массиве this.items. 
	 * Поиск ячейки в массиве происходит по id.  
     *
	 * @param item - заявка. 
	 * @param id - уникальный id заявки.
     * @return - true, если удалось ли провести операцию.
     */
	public boolean replace(String id, Item item) {
		boolean result = false;
		
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
		
		return result;		
	}
	
	/**
     * Метод findAll() возвращает копию массива this.items без null элементов.
	 *
     * @return - копия массива this.items без null элементов.
     */
	public Item[] findAll() {
		Item{} itemsCopy = new Item[100];
		
		return itemsCopy;
	}
	
	/**
     * Метод findByName() осуществляет поиск заявки по имени (name).
	 * проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item) 
	 * с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
	 *
	 * @param key - имя для поиска. 
     * @return - keyName[] - результирующий массив.
     */
	public Item[] findByName(String key) {
		
	}
	
	/**
     * Метод findById() осуществляет поиск заявки по id.
	 * проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id и возвращает найденный Item. 
	 * Если Item не найден - возвращает null.
	 *
	 * @param id - уникальный id заявки. 
     * @return - .
     */
	public Item findById(String id) {
		
	}
}


