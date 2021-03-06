package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для проверки класса Max по определению максимумального из двух чисел.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.1
 * @since 2018.11.12
 */
public class MaxTest {
    /**
     * Тест метода max.
     * first = 1, second = 2, result = 2
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест метода maxThree.
     * first = 1, second = 2, third = 3, result = 3
     */
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.maxThree(1, 2, 3);
        assertThat(result, is(3));
    }
}
