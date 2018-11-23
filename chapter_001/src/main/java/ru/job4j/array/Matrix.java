package ru.job4j.array;

/**
 *Класс Matrix для создания матрицы таблицы умножения. 
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.23
 */
 
public class Matrix {
	
	/**
	*Метод sort для создания матрицы таблицы умножения размером size-on-size.
	*@param size - размер матрицы.
	*@return table - матрицы таблицы умножения размером size-on-size.
	*/
    	public int[][] multiple(int size) {
        int[][] table = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					table[i][j] = (i + 1) * (j + 1);
				}
			}
        return table;
    }
}
			