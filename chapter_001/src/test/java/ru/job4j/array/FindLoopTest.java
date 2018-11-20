package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс FindLoopTest для тестирования класса FindLoop для поиска индекса заданного элемента в массиве.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.20
 */
public class FindLoopTest {
/**
*Задан массив {5, 10, 3}. Найти индекс элемента "5". Результат: 0.
*/
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
/**
*Задан массив {5, 10, 3}. Найти индекс элемента "4". Результат: -1, т.к. элемента нет в массиве.
*/
    @Test
    public void whenArrayHasLengh4ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }	
}
