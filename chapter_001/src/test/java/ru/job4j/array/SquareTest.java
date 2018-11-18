package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс SquareTest для тестирования класса Square (заполнение массива заданного размера числами возведёнными в квадрат).
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.18
 */
public class SquareTest {
    @Test
	/**
	*Тест - массив с 3-мя ячейками: [0]: 1*1=1; [1]: 2*2=4; [2]: 3*3=9.
	*/
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
	@Test
	/**
	*Тест - массив с 4-мя ячейками: [0]: 1*1=1; [1]: 2*2=4; [2]: 3*3=9; [3]: 4*4=16.
	*/
    public void whenBound4Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16};
        assertThat(rst, is(expect));
    }
	@Test
	/**
	*Тест - массив с 5-мя ячейками: [0]: 1*1=1; [1]: 2*2=4; [2]: 3*3=9; [3]: 4*4=16; [4]: 5*5=25.
	*/
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }
}