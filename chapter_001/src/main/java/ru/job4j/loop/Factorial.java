package ru.job4j.loop;

/**
 *Класс Factorial для подсчета факториала заданного целого положительного числа.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.14
 */
 
 public class Factorial {

	/**
	 * Метод calc для подсчета факториала заданного целого положительного числа.
	 *
	 * @param n - заданное целое положительное число.
	 * @return factorial - суммы чётных чисел в заданном диапазоне.
	 */
	public int calc(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
