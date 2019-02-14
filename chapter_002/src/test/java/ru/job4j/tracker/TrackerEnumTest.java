package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerEnumTest {

    /**
     * Тест проверяющий добавление заявки в трекер (add),
     * а также тест для возвращения копии массива (findAll).
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
      //  TrackerEnum tracker = new TrackerEnum(); // Не дает создать объект!
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Тест для замены (редактирования) заявки в трекере (replace),
     * а также тест для поиска по id (findById).
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объекте проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше, в next, т.к. id надо сохранить прежним!
        next.setId(previous.getId());
        // Обновляем заявку в трекере. next имеет тот же id, что и previous.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новое имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест для удаления заявки в трекере.
     */

    @Test
    public void whenDeleteItemThenShiftLeft() {
        Tracker tracker = new Tracker();
        // Создаем заявку #1.
        Item itemone = new Item("test1", "testDescription1", 1L);
        // Создаем заявку #2.
        Item itemtwo = new Item("test2", "testDescription2", 12L);
        // Создаем заявку #3.
        Item itemthree = new Item("test3", "testDescription3", 123L);
        // Создаем заявку #4.
        Item itemfour = new Item("test4", "testDescription4", 1234L);
        // Создаем заявку #5.
        Item itemtfive = new Item("test5", "testDescription5", 12345L);
        // Добавляем заявку #1 в трекер.
        tracker.add(itemone);
        // Добавляем заявку #2 в трекер.
        tracker.add(itemtwo);
        // Добавляем заявку #3 в трекер.
        tracker.add(itemthree);
        // Добавляем заявку #4 в трекер.
        tracker.add(itemfour);
        // Добавляем заявку #5 в трекер.
        tracker.add(itemtfive);

    /*Вывод на печать всего массива.
        System.out.println("All massive.");
        System.out.println("-------------------------------------------------------");
        System.out.println("Position|  Id             |  Name    |     Description         ");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(i + "       |  " + tracker.findAll()[i].getId() + "  |  " + tracker.findAll()[i].getName() + "  |  " + tracker.findAll()[i].getDesc());
            System.out.println("-------------------------------------------------------");
        }
	*/
        //Удаляем заявку #1. 0-ячейка.
        //System.out.println("Delete  item#1. 0-cell.");
        tracker.delete(itemone.getId());
        // Проверяем, что заявка #2 находится в ячейке 0.
        assertThat(tracker.findAll()[0], is(itemtwo));
	/*
        System.out.println("-------------------------------------------------------");
        System.out.println("Position|    Id           |  Name   |     Description         ");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(i + "       |  " + tracker.findAll()[i].getId() + "  |  " + tracker.findAll()[i].getName() + "  |  " + tracker.findAll()[i].getDesc());
            System.out.println("-------------------------------------------------------");
        }
	*/
        //Удаляем заявку #3. Середина массива.
        //System.out.println("Delete  item#3. Middle-cell.");
        tracker.delete(itemthree.getId());
        // Проверяем, что заявка #4 находится в ячейке 1.
        assertThat(tracker.findAll()[1], is(itemfour));
	/*
        System.out.println("-------------------------------------------------------");
        System.out.println("Position|    Id           |  Name   |     Description         ");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(i + "       |  " + tracker.findAll()[i].getId() + "  |  " + tracker.findAll()[i].getName() + "  |  " + tracker.findAll()[i].getDesc());
            System.out.println("-------------------------------------------------------");
        }
	*/
        //Удаляем заявку #5. Последняя ячейка.
        //System.out.println("Delete  item#5. Last-cell.");
        tracker.delete(itemtfive.getId());
        // Проверяем, что во 2-й ячейке null.
        //assertThat(tracker.findAll()[2], is(null));
	/*
        System.out.println("-------------------------------------------------------");
        System.out.println("Position|    Id           |  Name   |     Description         ");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(i + "       |  " + tracker.findAll()[i].getId() + "  |  " + tracker.findAll()[i].getName() + "  |  " + tracker.findAll()[i].getDesc());
            System.out.println("-------------------------------------------------------");
        }
	*/
    }

    /**
     * Тест для поиска заявок в трекере с одинаковыми именами (name).
     */
    @Test
    public void whenItemsFindByName() {
        Tracker tracker = new Tracker();
        // Создаем заявку #1.
        Item itemone = new Item("test1", "testDescription1", 123L);
        // Создаем заявку #2.
        Item itemtwo = new Item("test2", "testDescription2", 1234L);
        // Создаем заявку #3.
        Item itemthree = new Item("test2", "testDescription3", 12345L);
        // Добавляем заявку #1 в трекер.
        tracker.add(itemone);
        // Добавляем заявку #2 в трекер.
        tracker.add(itemtwo);
        // Добавляем заявку #3 в трекер.
        tracker.add(itemthree);
        //Поиск заявки в трекере по имени.
        assertThat(tracker.findByName("test2")[0].getName(), is("test2"));
        assertThat(tracker.findByName("test2")[1].getName(), is("test2"));
    }
}