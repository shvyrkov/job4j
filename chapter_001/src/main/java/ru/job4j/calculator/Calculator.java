package ru.job4j.calculator;

/**
 * Класс Calculator для вычисления арифметических операций.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.10.18
 */
public class Calculator {
    /**
     * result - возвращаемый параметр.
     */
    private double result;

    /**
     * Метод add - сложение значений двух переменных first и second.
     *
     * @param first  - 1-я переменная.
     * @param second - 2-я переменная.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод subtract - вычитание значения переменной second из first.
     *
     * @param first  - 1-я переменная.
     * @param second - 2-я переменная.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод multiple - умножение значений двух переменных first и second.
     *
     * @param first  - 1-я переменная.
     * @param second - 2-я переменная.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод div - деление значения переменной first на second.
     *
     * @param first  - 1-я переменная.
     * @param second - 2-я переменная.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод getResult - возврат значения переменной result.
     *
     * @return - возвращает результат арифметической операции (result).
     */
    public double getResult() {
        return this.result;
    }
}