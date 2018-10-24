package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Тест для класса Calculator (вычисление арифметических операций).
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.10.18
 */
 
public class CalculatorTest {
	/**
    *Тест метода add (сложение).
    */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	/**
    *Тест метода subtract (вычитание).
    */
    @Test
    public void whenSubtractTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
	/**
    *Тест метода multiple (умножение).
    */
    @Test
    public void whenMultipleTwoMultiplyTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
	/**
    *Тест метода div (деление).
    */
    @Test
    public void whenDivFourDivTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}