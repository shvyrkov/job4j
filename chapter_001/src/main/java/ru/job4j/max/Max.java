package ru.job4j.max;

/**
 * Определение максимумального из двух чисел.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.1
 * @since 2018.11.12
 */
 
public class Max {
	/**
	 * Метод для определение максимумального из двух чисел - first или second.
	 *
	 * @param first  - 1-е число.
	 * @param second - 2-е число.
	 * @return result - максимальное из first и second.
	 */
	public int max(int first, int second) {
		return first > second ? first : second;
	}
	/**
	 * Метод для определение максимумального из трёх чисел - first, second или third.
	 *
	 * @param first  - 1-е число.
	 * @param second - 2-е число.
	 * @param third - 3-е число.
	 * @return temp - максимальное из трёх чисел.
	 */
	public int maxThree(int first, int second, int third) {
	int temp = this.max(first, second);
	temp = this.max(temp, third);
	return temp;
	}
}