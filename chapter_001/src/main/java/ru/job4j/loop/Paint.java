package ru.job4j.loop;

/**
 *Класс Paint для построения пирамиды заданной высоты в псевдографике.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.16
 */
 
public class Paint {
    /**
     * Метод pyramid для построения пирамиды заданной высоты.
     *
     * @param height - высота пирамиды.
     * @return - пирамида заданной высоты в псевдографике.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
	// Ширина = 2 высоты минус 1 клетка(центр).	
        int weight = 2 * height - 1;
	// Внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
	// Внутренний цикл определяет положение ячейки в строке.		
            for (int column = 0; column != weight; column++) {
	// если строка удовлетворяет условию ячейки (слева и справа), то рисуем галку. 			
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
	// Добавляем перевод строки.		
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

/**
* Метод rightTrl для построения правосторонней пирамиды заданной высоты.
*
* @param height - высота пирамиды.
* @return - правосторонняя пирамида.
*/
    public String rightTrl(int height) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // ширина будет равна высоте. 
        int weight = height; 
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                // если строка равна ячейки, то рисуем галку. 
                // в данном случае строка определяет, сколько галок будет на строке
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }
/**	
* Метод leftTrl для построения левосторонней пирамиды заданной высоты.
*
* @param height - высота пирамиды.
* @return - правосторонняя пирамида.	
*/
	public String leftTrl(int height) {
		StringBuilder screen = new StringBuilder();
		int weight = height;
		for (int row = 0; row != height; row++) {
			for (int column = 0; column != weight; column++) {
				if (row >= weight - column - 1) {
					screen.append("^");
					} else {
                screen.append(" ");
				}
			}
			screen.append(System.lineSeparator());
		}
		return screen.toString();
	}
}
