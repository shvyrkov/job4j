package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс TrackerInnerClassTest - тест для проверки "синглетности" TrackerInnerClass. (Lazy loading)
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.02.15
 */
public class TrackerInnerClassTest {

    /**
     * В тесте создаются 2 ссылки на 2 объекта. Один объект изменяется и проверяется,
     * что они ссылаются на один и тот же объект.
     */
    @Test
    public void singletonTestInnerClassSameObject() {
        TrackerInnerClass expect = TrackerInnerClass.getInstance();
        TrackerInnerClass result = TrackerInnerClass.getInstance();
        Item item = new Item("test1", "testDescription", 123L);
        result.add(item);
        assertThat(result, is(expect));
    }
}