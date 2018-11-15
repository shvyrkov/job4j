package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тесты для класса BoardTest:
 * 1. Построение шахматной доски 3х3.
 * 2. Построение шахматной доски 5х4.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.15
 */
public class BoardTest {
	
/**
 * 1. Построение шахматной доски 3х3.
 */
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                    String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }	
/**
 * 2. Построение шахматной доски 5х4.
 */
     @Test
    public void when5x4() {
        Board board = new Board();
        String rsl = board.paint(5, 4);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                    String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
                )
        );
    }
}
