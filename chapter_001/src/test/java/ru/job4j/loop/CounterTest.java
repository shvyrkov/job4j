package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.1
 * @since 2018.11.12
 */
public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
		Counter summa = new Counter();
			int result = summa.add(1, 10);
			assertThat(result, is(30));
    }
}