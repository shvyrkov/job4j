package ru.job4j.converter;

/**
 * Корвертор валюты.
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.10.25
 */
public class Converter {
    /**
     * euro, dollar, ruble - возвращаемые параметры.
     */
//   private int euro;
//   private int dollar;
//   private int ruble;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
		int euro = value / 75;
        return euro;
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
		int dollar = value / 65;
        return dollar;
    }
	/**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
		int ruble = value * 75;
        return ruble;
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
		int ruble = value * 65;
        return ruble;
    }
}