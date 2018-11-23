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
	/**
	 * Тест, проверяющий создание матрицы таблицы умножения размером 5 на 5. 
	 */
	@Test
	public void when5on5() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(5);
        int[][] expect = {
                {1, 2, 3, 4, 5},
				{2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15},
				{4, 8, 12, 16, 20},
				{5, 10, 15, 20, 25},
        };
        assertThat(table, is(expect));
    }
		/**
	 * Тест, проверяющий создание матрицы таблицы умножения размером 8 на 8. 
	 */
	@Test
	public void when8on8() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(8);
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 8},
				{2, 4, 6, 8, 10, 12, 14, 16},
                {3, 6, 9, 12, 15, 18, 21, 24},
				{4, 8, 12, 16, 20, 24, 28, 32},
				{5, 10, 15, 20, 25, 30, 35, 40},
				{6, 12, 18, 24, 30, 36, 42, 48},
				{7, 14, 21, 28, 35, 42, 49, 56},
				{8, 16, 24, 32, 40, 48, 56, 64}
        };
        assertThat(table, is(expect));
	}
}