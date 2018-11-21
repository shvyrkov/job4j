package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс TurnTest для тестирования класса Turn для перестановки элементов массива в обратном порядке.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.21
 */
public class TurnTest {
/**
*Задан массив {4, 1, 6, 2} с чётным количеством элементов. Результат: {2, 6, 1, 4}.
*/
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    /**
     *Задан массив {1, 2, 3, 4, 5} с нечётным количеством элементов. Результат: {5, 4, 3, 2, 1}.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
            Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.back(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}
