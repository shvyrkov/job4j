package ru.job4j.array;

/**
 *Класс TwoInOneSort для слияния двух отсортированных массивов в один.
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.12.08
 */
 public class TwoInOneSort {
	/**
	*Метод sortTwoInOne осуществляет слияния двух отсортированных по возрастанию массивов 
	*в третий также отсортированный по возрастанию.
	*@param arrayOne - отсортированный по возрастанию массив целых чисел №1.
	*@param arrayTwo - отсортированный по возрастанию массив целых чисел №2.
	*@return array - результат слияния массивов №1 и №2 отсортированный по возрастанию.
	*/
    public int[] mergerTwoInOne(int[] arrayOne, int[] arrayTwo) {
		int i = 0;	
		int j = 0;
		int k = 0;
		int[] array = new int[arrayOne.length + arrayTwo.length];
		
//		for (int i = 0; i < arrayOne.length; ) {			
//			for (int j = 0; j < arrayTwo.length; ) {
	
		while (i < arrayOne.length && j < arrayTwo.length) {
				
			if (arrayOne[i] < arrayTwo[j]) {					
				array[k++] = arrayOne[i++];
			} else {
				array[k++] = arrayTwo[j++];
			}
		}
		while (i < arrayOne.length) {
		array[k++] = arrayOne[i++];	
		}
		while (i < arrayTwo.length) {
		array[k++] = arrayTwo[i++];
		}
	return array;
	}
}
			