package ru.job4j.profession;

/**
 * Класс Profession - суперкласс для создания перечня профессий.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.12.25
 */
public class Profession {
    String name;
    String profession;

    /**
     * Метод getName возвращает имя специалиста.
     *
     * @param name - имя специалиста.
     * @return name - имя специалиста.
     */
    public String getName(String name) {
        return name;
    }
}

/**
 * Класс Doctor - подкласс для профессии Доктор.
 */
public class Doctor extends Profession {
    /**
     * Метод heal возвращает диагноз пациента.
     *
     * @param patient - пациент.
     * @return diagnose - диагноз пациента.
     */
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}

/**
 * Класс Engineer - подкласс для профессии Инженер.
 */
public class Engineer extends Profession {
    public void build(House house) {
    }
}

/**
 * Класс Teacher - подкласс для профессии Учитель.
 */
public class Teacher extends Profession {
    public void teach(Student student) {
    }
}

/**
 * Класс Diagnose - класс Диагноза.
 */
public class Diagnose {
}

/**
 * Класс Patient - класс Пациента.
 */
public class Patient {
    String name;
}

/**
 * Класс House - класс Дома.
 */
public class House {
}

/**
 * Класс Student - класс Студента.
 */
public class Student {
}
