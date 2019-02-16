package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.job4j.tracker.*;

/**
 * Класс TrackerEagerTest - тест для проверки "синглетности" TrackerEager. (Eager loading)
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.15
 */
public class TrackerEagerTest {

    /**
     * В тесте создаются 2 ссылки на 2 объекта. Один объект изменяется и проверяется,
     * что они ссылаются на один и тот же объект.
     */
    @Test
    public void singletonTestEagerSameObject() {
        TrackerEager expect = TrackerEager.getInstance();
        TrackerEager result = TrackerEager.getInstance();
        Item item = new Item("test1", "testDescription", 123L);
        result.add(item);
        assertThat(result, is(expect));
    }
}