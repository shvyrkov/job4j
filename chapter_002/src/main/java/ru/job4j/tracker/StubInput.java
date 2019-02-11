package ru.job4j.tracker;

/**
 * Класс StubInput - программа реализации методов интерфейса Input для имитации общения с пользователем.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.24
 */
public class StubInput implements Input {

    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например, если пользователь хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки.
     * desc - описание заявки.
     * 6 - выйти из трекера.
     * y - подтверждение выхода.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    /**
     * Конструктор
     *
     * @param value - последовательность ответов пользователя.
     * @param -     диапазон допустимых значений для ввода пользователем.
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, int[] range) {

        int key = Integer.valueOf(this.ask(question)); // Использует 1-й метод ask для ввода данных.
        // Автогенерация (by JVM) исключения NFE при вводе данных не типа int.
        boolean exist = false;
        for (int value : range) { // Сравнение введенного значения с заданным диапазоном.
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu rahge."); // Генерация исключения при выходе за границы массива.
        }
        return key;
    }
}