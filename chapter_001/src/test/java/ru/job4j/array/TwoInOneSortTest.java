package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс TwoInOneSortTest для тестирования класса TwoInOneSort для слияния двух отсортированных массивов.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.12.09
 */
public class TwoInOneSortTest {
	/**
	 * Тест, слияния двух отсортированных массивов {1,3,5,7} и {2,4,6}
	 */
	@Test
	public void when12357with246() {

		TwoInOneSort x = new TwoInOneSort();
		int[] arrayOne = {1, 3, 5, 7};
		int[] arrayTwo = {2, 4, 6};
		int[] result = x.mergerTwoInOne(arrayOne, arrayTwo);
		int[] expect = {1, 2, 3, 4, 5, 6, 7};
		assertThat(result, is(expect));
	}
	/**
	 * Тест, слияния двух отсортированных массивов {7,8,9} и {2,4,6,9}
	 */
	@Test
	public void when789with2469() {

		TwoInOneSort x = new TwoInOneSort();
		int[] arrayOne = {7, 8, 9};
		int[] arrayTwo = {2, 4, 6, 9};
		int[] result = x.mergerTwoInOne(arrayOne, arrayTwo);
		int[] expect = {2, 4, 6, 7, 8, 9, 9};
		assertThat(result, is(expect));
	}
}