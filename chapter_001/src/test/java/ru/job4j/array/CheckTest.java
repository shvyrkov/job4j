package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс CheckTest для тестирования класса Check для проверки, что все элементы в массиве являются true или false.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.21
 */
public class CheckTest {
/**
*Задан массив {true, true, true} с нечётным количеством элементов. Результат: true.
*/
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
/**
*Задан массив {true, false, true} с нечётным количеством элементов. Результат: false.
*/
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
/**
*Задан массив {false, false, false, false} с чётным количеством элементов. Результат: true.
*/
    @Test
    public void whenDataMonoByTrueThenTrueEven() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
/**
*Задан массив {true, false, false, true} с чётным количеством элементов. Результат: false.
*/
    @Test
    public void whenDataNotMonoByTrueThenFalseEven() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }	
}
