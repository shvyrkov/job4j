package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс StartUITest - для тестирования StartUI (эмуляция действий пользователя).
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.24
 */
public class StartUITest {

    /**
     * Тест проверяющий добавление заявки в трекер ("0. Add new Item").
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий для добавления заявки.
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Тест для проверки редактирования заявки в трекере ("2. Edit Item").
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item itemEdit = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", itemEdit.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(itemEdit.getId()).getName(), is("test replace"));
    }

    /**
     * Тест для проверки удаления заявки в трекере ("3. Delete Item").
     */
    @Test
    public void whenUserDeleteItemThenTrackerShiftNextItemOnDeletedItemPosition() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item1 = tracker.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2 = tracker.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
        Item item3 = tracker.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4 = tracker.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input input0 = new StubInput(new String[]{"3", item1.getId(), "Y", "6"});   // Удаление item1 из ячейки [0].
        new StartUI(input0, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test_name-2")); // проверяем, ячейка [0] в трекере содержит имя из ячейки [1], т.е.произошёл сдвиг влево.

        Input input1 = new StubInput(new String[]{"3", item3.getId(), "Y", "6"});   // Удаление item3 из ячейки [1], где она оказалась после предыдущего удаления.
        new StartUI(input1, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[1].getName(), is("test_name-4")); // проверяем, ячейка [1] в трекере содержит имя из ячейки [2], т.е.произошёл сдвиг влево.
    }
}