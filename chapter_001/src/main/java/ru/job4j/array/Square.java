package ru.job4j.array;

import static java.lang.Math.*;

/**
 *Класс Square для заполнения массива заданного размера числами возведёнными в квадрат.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.18
 */
 public class Square {

 /**
* Метод calculate заполненяет массив заданного размера bound числами от 1 до bound возведёнными в квадрат.
* @param bound - размер массива.
* @return rst - массив размера bound заполненный числами от 1 до bound возведёнными в квадрат.
*/
	 public int[] calculate(int bound) {
	// Объявление массива размера bound.	 
		int[] rst = new int[bound];
	// Заполнение массива через цикл элементами от 1 до bound возведенными в квадрат.
		for (int i = 0; i < bound; i++) {
			// Приведение к типу int, т.к. Math.pow выдает double.
			rst[i] = (int) Math.pow(i + 1, 2);
		}
		return rst;
	 }
 }	 
			