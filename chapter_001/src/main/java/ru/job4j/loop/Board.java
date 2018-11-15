package ru.job4j.loop;

/**
 *Класс Board для построения шахматной доски в псевдографике.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.15
 */
 
public class Board {
    /**
     * Метод paint для построения шахматной доски с заданным размером width x height.
     *
     * @param width  - ширина доски (ширина строки).
     * @param heigth - высота доски (высота столбца).
     * @return - шахматная доска в псевдографике.
     */
    public String paint(int width, int heigth) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        //Перебор строк.
        for (int i = 0; i < heigth; i++) {
            //Перебор в строке.
            // Сумма индексов всегда четное число => нужно проставлять X, иначе - пробел.
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
	        // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}