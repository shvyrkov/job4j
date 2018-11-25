package ru.job4j.array;

/**
 *Класс MatrixCheck для проверки матрицы, где по диагоналям должны быть только true или false.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.24
 */
public class MatrixCheck {
/**
*Метод mono осуществляет проверку матрицы, если по диагоналям только true или false, то result = true.
*@param data - начальный массив типа  boolean.
*@return result - true, если по диагоналям только true или false.
*/
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
			if ((data[i][i] != data[0][0]) || (data[i][data.length - i - 1] != data[0][data.length - 1])) {
				result = false;
				break;
			}
        }
        return result;
    }
}
