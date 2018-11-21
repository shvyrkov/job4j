package ru.job4j.array;

/**
 *Класс Check для проверки, что все элементы в массиве являются true или false.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.21
 */
 public class Check {
/**
*Метод mono осуществляет проверку, что все элементы в массиве являются true или false.
*@param data - массив типа boolean.
*@return result - true, если все элементы в массиве являются true или false.
*/		
	public boolean mono(boolean[] data) {
        boolean result = false;
		int temptrue = 0;
        for (int i = 0; i < data.length; i++) {
			if (data[i]) {
				temptrue++;
			}
		}
		if ((temptrue == data.length) | (temptrue == 0)) {
			result = true;
			}
        return result;
    }
}
			