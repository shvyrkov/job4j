package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест для класса Factorial, проверяющий, что:
 * 1. Факториал для числа 5 будет равен 120 (1 * 2 * 3 * 4 * 5).
 * 2. Факториал для числа 0 равен 1
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.14
 */
public class FactorialTest {
	
/**Тест для класса Factorial, проверяющий, что:
 * 1. Факториал для числа 5 будет равен 120 (1 * 2 * 3 * 4 * 5).
 */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
			int result = factorial.calc(5);
			assertThat(result, is(120));
		}
	
/**Тест для класса Factorial, проверяющий, что:
 * 2. Факториал для числа 0 равен 1
 */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
            Factorial factorial = new Factorial();
			int result = factorial.calc(0);
			assertThat(result, is(1));
		}
}
