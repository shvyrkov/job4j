package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс BubbleSortTest для тестирования класса BubbleSort для создания матрицы таблицы умножения. 
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.23
 */
public class MatrixTest {
	/**
	 * Тест, проверяющий создание матрицы таблицы умножения размером 2 на 2. 
	 */
	@Test
	public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}