package ru.job4j.profession;

/**
 * Класс Doctor - подкласс от Profession для профессии Доктор.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.12.27
 */
public class Doctor extends Profession {
    /**
     * Метод heal возвращает диагноз пациента.
     *
     * @param patient - данные о пациенте.
     * @return diagnose - диагноз пациента.
     */
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}