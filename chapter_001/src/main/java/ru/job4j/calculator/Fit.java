package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.02
 */
public class Fit {

    /**
     * Идеальный вес для мужщины.
     * @param height Рост в см.
     * @return идеальный вес в кг.
     */
    public double manWeight(double height) {
        return (height - 100.0) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост в см.
     * @return идеальный вес в кг.
     */
    public double womanWeight(double height) {
        return (height - 110.0) * 1.15;
    }
}