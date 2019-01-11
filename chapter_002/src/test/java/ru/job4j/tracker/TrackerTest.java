package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TrackerTest - тест для хранилища заявок.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.10
 */
public class TrackerTest {

    /**
     * Тест проверяющий добавление заявки в трекер (add),
     * а также тест для возвращения копии массива (findAll).
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
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
        Item itemone = new Item("test1", "testDescription1", 123L);
        // Создаем заявку #2.
        Item itemtwo = new Item("test2", "testDescription2", 1234L);
        // Создаем заявку #3.
        Item itemthree = new Item("test3", "testDescription3", 12345L);
        // Добавляем заявку #1 в трекер.
        tracker.add(itemone);
        // Добавляем заявку #2 в трекер.
        tracker.add(itemtwo);
        // Добавляем заявку #3 в трекер.
        tracker.add(itemthree);
        // Удаляем заявку #2.
        tracker.delete(itemtwo.getId());
        // Проверяем, что заявка #3 находится в ячейке 1.
        assertThat(tracker.findAll()[1], is(itemthree));
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
