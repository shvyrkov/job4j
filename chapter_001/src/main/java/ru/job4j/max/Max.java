package ru.job4j.max;

/**
 * Определение максимумального из двух чисел.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.09
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
}