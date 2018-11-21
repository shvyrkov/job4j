package ru.job4j.array;

/**
 *Класс Turn для перестановки элементов массива в обратном порядке.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.21
 */
 public class Turn {
/**
*Метод back осуществляет перестановку элементов массива в обратном порядке.
*@param array - начальный массив типа  int.
*@return array - начальный массив с переставленными в обратном порядке элементами.
*/		
    public int[] back(int[] array) {
        for (int i = 0; i < (int) (array.length / 2); i++) {
			int temp = array[array.length - i - 1];
			array[array.length - i - 1] = array[i];
			array[i] = temp;
        }
        return array;
    }
}
			