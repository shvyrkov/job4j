package ru.job4j.array;

/**
 *Класс BubbleSort для сортировки массива методом перестановки. 
 *	"Пузырьковый метод".
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.22
 */
 
public class BubbleSort {
	
	/**
	*Метод сортировки массива целых чисел с помощью алгоритма сортировки пузырьком;
	*@param array - входящий несортированный массив целых чисел.
	*@return array - отсортированный в порядке возрастания входящий массив.
	*/
    
	public int[] sort(int[] array) {
		int temp = 0;		
		for (int i = 0; i < array.length - 1; i++) {			
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {					
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	return array;
	}
}
			