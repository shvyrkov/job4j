package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс BubbleSortTest для тестирования класса BubbleSort для сортировки массива методом перестановки.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.22
 */
public class BubbleSortTest {
	/**
	 * Тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
	 */
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort testbubble = new BubbleSort();
		int[] bubble = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
		int[] result = testbubble.sort(bubble);
		int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(result, is(expect));
	}
}