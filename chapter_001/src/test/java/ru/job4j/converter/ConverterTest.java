package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Тест для класса Converter (конвертации евро, долларов в рубли и обратно).
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.10.25
 */
public class ConverterTest {
	/**
    *Тест метода rubleToDollar (конвертация рублей в доллары по курсу 65 руб./$).
    */
    @Test
    public void when65RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(65);
        assertThat(result, is(1));
    }
	/**
    *Тест метода rubleToEuro (конвертация рублей в евро по курсу 75 руб./евро.
    */
    @Test
    public void when75RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(75);
        assertThat(result, is(1));
    }
	/**
    *Тест метода dollarToRuble (конвертация долларов в рубли по курсу 65 руб./$).
    */
	 @Test
    public void when65DollarToRubleThen1() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(65));
    }
	/**
    *Тест метода rubleToDollar (конвертация евро в рубли по курсу 75 руб./$).
    */
    @Test
    public void when75EuroToRubleThen1() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(75));
    }
}