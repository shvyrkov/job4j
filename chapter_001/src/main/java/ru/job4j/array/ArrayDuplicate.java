package ru.job4j.array;

import java.util.Arrays;
/**
 *Класс ArrayDuplicate для удаления дубликатов в массиве.
 *	
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.25
 */
 
public class ArrayDuplicate {
	
	/**
	*Метод удаляет все дубликаты в массиве типа String.
	*@param array - входящий массив типа String.
	*@return - массив типа String без дубликатов.
	*/
    public String[] remove(String[] array) {
		int unique = array.length;
		for (int out = 0; out < unique; out++) {			
			for (int in = out + 1; in < unique; in++) {
				if (array[out].equals(array[in])) {
					array[in] = array[unique - 1];
					unique--;
					in--;
				}
			}
		}
	return Arrays.copyOf(array, unique);
	}
}
			