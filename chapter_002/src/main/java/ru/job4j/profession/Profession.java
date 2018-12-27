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

