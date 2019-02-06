package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс StartUITest - для тестирования StartUI (эмуляция действий пользователя).
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.1 Refactoring
 * @since 2019.01.24
 */
public class StartUITest {
    // Константа Menu
    private final StringBuilder menu = new StringBuilder()
//            .append(System.lineSeparator())
//            .append("       Menu.")
//            .append(System.lineSeparator())
            .append("0. Add new Item.")
            .append(System.lineSeparator())
            .append("1. Show all Items.")
            .append(System.lineSeparator())
            .append("2. Edit Item.")
            .append(System.lineSeparator())
            .append("3. Delete Item.")
            .append(System.lineSeparator())
            .append("4. Find Item by Id.")
            .append(System.lineSeparator())
            .append("5. Find Items by Name.")
            .append(System.lineSeparator())
            .append("6. Exit Program.")
            .append(System.lineSeparator());
//            .append(System.lineSeparator());

    // Константа Заголовка.
    private final StringBuilder header = new StringBuilder()
            .append(System.lineSeparator())
            .append("--------------------------------------------------")
            .append(System.lineSeparator())
            .append("   Id           |   Name      |   Description     ")
            .append(System.lineSeparator())
            .append("--------------------------------------------------")
            .append(System.lineSeparator());

    // Константа для разделительной линии в таблице.
    private final StringBuilder interline = new StringBuilder()
            .append(System.lineSeparator())
            .append("--------------------------------------------------");

    // Константа для нижнего колонтитула.
    private final StringBuilder footer = new StringBuilder()
            .append(System.lineSeparator())
            .append("----------------- End of list --------------------")
            .append(System.lineSeparator());

    // поле содержит дефолтный (стандартный) вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before // Выполняется перед каждым тестом.
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out)); // вывод результата в буфер
    }

    @After // Выполняется после каждого теста.
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method"); // возврат стандартного вывода в консоль
    }

    /**
     * Тест проверяющий добавление заявки в трекер ("1. Add new Item").
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6", "y"});   //создаём StubInput с последовательностью действий для добавления заявки.
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Тест для проверки редактирования заявки в трекере ("3. Edit Item").
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item itemEdit = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", itemEdit.getId(), "test replace", "заменили заявку", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(itemEdit.getId()).getName(), is("test replace"));
    }

    /**
     * Тест для проверки удаления заявки в трекере ("4. Delete Item").
     */
    @Test
    public void whenUserDeleteItemThenTrackerShiftNextItemOnDeletedItemPosition() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item1 = tracker.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2 = tracker.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
        Item item3 = tracker.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4 = tracker.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input input0 = new StubInput(new String[]{"3", item1.getId(), "y", "6", "y"});   // Удаление item1 из ячейки [0].
        new StartUI(input0, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test_name-2")); // проверяем, ячейка [0] в трекере содержит имя из ячейки [1], т.е.произошёл сдвиг влево.

        Input input1 = new StubInput(new String[]{"3", item3.getId(), "y", "6", "y"});   // Удаление item3 из ячейки [1], где она оказалась после предыдущего удаления.
        new StartUI(input1, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[1].getName(), is("test_name-4")); // проверяем, ячейка [1] в трекере содержит имя из ячейки [2], т.е.произошёл сдвиг влево.
    }

    /**
     * Тест для проверки всего массива заявок после удаления заявки в трекере ("3. Delete Item").
     */
    @Test
    public void whenUserDeleteItemThenCompareWholeArray() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item1 = tracker.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2 = tracker.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
        Item item3 = tracker.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4 = tracker.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Tracker expect1 = new Tracker();     // создаём Tracker для сравнения
//        Item item1e1 = expect1.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2e1 = expect1.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
        Item item3e1 = expect1.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4e1 = expect1.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input input00 = new StubInput(new String[]{"3", item1.getId(), "y", "6", "y"});   // Удаление item1 из ячейки [0].
        new StartUI(input00, tracker).init();     //   создаём StartUI и вызываем метод init()
        for (int i = 0; i < tracker.findAll().length; i++) {
            assertThat(tracker.findAll()[i].getName(), is(expect1.findAll()[i].getName())); // проверяем весь массив после удаления заявки
        }

        Tracker expect2 = new Tracker();     // создаём Tracker для сравнения
//        Item item1e2 = expect2.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2e2 = expect2.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
//        Item item3e2 = expect2.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4e2 = expect2.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input input11 = new StubInput(new String[]{"3", item3.getId(), "y", "6", "y"});   // Удаление item3 из середины массива.
        new StartUI(input11, tracker).init();     //   создаём StartUI и вызываем метод init()
        for (int i = 0; i < tracker.findAll().length; i++) {
            assertThat(tracker.findAll()[i].getName(), is(expect2.findAll()[i].getName())); // проверяем весь массив после удаления заявки
        }
        Tracker expect3 = new Tracker();     // создаём Tracker для сравнения
//        Item item1e3 = expect3.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2e3 = expect3.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
//        Item item3e3 = expect3.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
//        Item item4e3 = expect3.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input input22 = new StubInput(new String[]{"3", item4.getId(), "y", "6", "y"});   // Удаление item4 из последней ячейки массива
        new StartUI(input22, tracker).init();     //   создаём StartUI и вызываем метод init()
        for (int i = 0; i < tracker.findAll().length; i++) {
            assertThat(tracker.findAll()[i].getName(), is(expect3.findAll()[i].getName())); // проверяем весь массив после удаления заявки
        }
    }

    /**
     * Тест проверяющий вывод списка заявок в консоль ("2. List of all Items").
     */
    @Test
    public void whenUserAsksListOfAllItems() {
        Tracker trackerList = new Tracker();     // создаём Tracker
        Item item1a = trackerList.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2a = trackerList.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
        Item item3a = trackerList.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4a = trackerList.add(new Item("test_name-4", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input input = new StubInput(new String[]{"1", "6", "y"});   // Вывод списка.
        new StartUI(input, trackerList).init();     //   создаём StartUI и вызываем метод init()

        assertThat(
                new String(out.toByteArray()), // Получение результата из буфера.
                is(
                        new StringBuilder()
                                .append(menu)
                                .append(System.lineSeparator())
                                .append("--------------- List of all Items ----------------")
                                .append(header)
                                .append(" " + trackerList.findAll()[0].getId() + "  |  test_name-1  |  desc_1")
                                .append(interline)
                                .append(System.lineSeparator())
                                .append(" " + trackerList.findAll()[1].getId() + "  |  test_name-2  |  desc_2")
                                .append(interline)
                                .append(System.lineSeparator())
                                .append(" " + trackerList.findAll()[2].getId() + "  |  test_name-3  |  desc_3")
                                .append(interline)
                                .append(System.lineSeparator())
                                .append(" " + trackerList.findAll()[3].getId() + "  |  test_name-4  |  desc_4")
                                .append(interline)
                                .append(footer)
                                .append(menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тест проверяющий поиск заявок по имени и вывод списка этих заявок в консоль ("6. Find Item by Name").
     */
    @Test
    public void whenUserFindItemByName() {
        Tracker trackerName = new Tracker();     // создаём Tracker
        Item item1n = trackerName.add(new Item("test_name-1", "desc_1")); //Добавляем заявку 1 в ячейку [0]
        Item item2n = trackerName.add(new Item("test_name-2", "desc_2")); //Добавляем заявку 2 в ячейку [1]
        Item item3n = trackerName.add(new Item("test_name-3", "desc_3")); //Добавляем заявку 3 в ячейку [2]
        Item item4n = trackerName.add(new Item("test_name-2", "desc_4")); //Добавляем заявку 4 в ячейку [3]

        Input inputId = new StubInput(new String[]{"5", "test_name-2", "6", "y"}); // Поиск по имени "test_name-2"
        new StartUI(inputId, trackerName).init();     //   создаём StartUI и вызываем метод init()

        assertThat(
                new String(out.toByteArray()), // Получение результата из буфера.
                is(
                        new StringBuilder()
                                .append(menu)
                                .append(System.lineSeparator())
                                .append("-------- List of Items with Name 'test_name-2'---------")
                                .append(header)
                                .append(" " + trackerName.findByName("test_name-2")[0].getId() + "  |  test_name-2  |  desc_2")
                                .append(interline)
                                .append(System.lineSeparator())
                                .append(" " + trackerName.findByName("test_name-2")[1].getId() + "  |  test_name-2  |  desc_4")
                                .append(interline)
                                .append(footer)
                                .append(menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}