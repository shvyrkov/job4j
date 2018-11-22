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
        for (int i = 0; i < data.length; i++) {
			if (data[0] != data[i]) {
				result = false;
				break;
			} else {
				result = true;
			}
		}
        return result;
    }
}
			