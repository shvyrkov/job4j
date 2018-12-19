package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
/**
 *Класс ArrayDuplicateTest для тестирования класса ArrayDuplicate для удаления дубликатов в массиве.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.25
 */
public class ArrayDuplicateTest {
	/**
	 * Тест, проверяющий удаления дубликатов в массиве {"Привет", "Мир", "Привет", "Супер", "Мир", "Супер"}.
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate duplicate = new ArrayDuplicate();
		String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир", "Супер"};
		String[] result = duplicate.remove(array);
		String[] expect = {"Привет", "Мир", "Супер"};
		assertThat(result, arrayContainingInAnyOrder(expect));
	}
	/**
	 * Тест, проверяющий удаления дубликатов в массиве {"1", "1", "2", "3", "1", "4", "1"}.
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicateInt() {
		ArrayDuplicate duplicate = new ArrayDuplicate();
		String[] array = {"1", "1", "2", "3", "1", "4", "1"};
		String[] result = duplicate.remove(array);
		String[] expect = {"1", "2", "3", "4"};
		assertThat(result, arrayContainingInAnyOrder(expect));
	}
}