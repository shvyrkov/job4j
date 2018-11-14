package ru.job4j.loop;

/**
 *Класс Counter для подсчета суммы чётных чисел в заданном диапазоне.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.13
 */
 
 public class Counter {

 /**
 *Задание начала (start) и конца (finish) диапазона для подсчета суммы.
 */
//	private int start;
//	private int finish;
	
/**
 *Метод add для подсчета суммы чётных чисел в заданном диапазоне.
 *@param start - начало диапазона.
 *@param finish - конец диапазона.
 *@return sum - суммы чётных чисел в заданном диапазоне.
 */	
	public int add(int start, int finish) {
		int sum = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}