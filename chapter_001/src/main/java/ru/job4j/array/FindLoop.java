package ru.job4j.array;

/**
 *Класс FindLoop для поиска элемента в массиве.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.20
 */
 public class FindLoop {
/**
*Метод indexOf осуществляет поиск заданного элемента в массиве.
*@param data - массив.
*@param el - элемент массива для поиска.
*@return rst - индекс искомого элемента, если элемента нет в массиве, то возвращаем -1.
*/		
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
			