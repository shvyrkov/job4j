package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Класс MatrixCheckTest для тестирования класса MatrixCheckTest -
 * - для проверки матрицы, где по диагоналям должны быть только true или false. 
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.24
 */		
public class MatrixCheckTest {
	/**
	 * Тест, проверяющий матрицу 3х3. Все диагонали - true, результат  - true. 
	 */
    @Test
    public void whenDataMonoByTrueThenTrueOdd() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
	/**
	 * Тест, проверяющий матрицу 3х3. По одной диагонали - true, false, true, по другой - все false, результат  - false. 
	 */
    @Test
    public void whenDataNotMonoByTrueThenFalseOdd() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
	/**
	 * Тест, проверяющий матрицу 4х4. По одной диагонали - все true, по другой - все false, результат  - true. 
	 */
    @Test
    public void whenDataMonoByTrueThenTrueEven() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, false, true},
                {true, false, true, false},
				{false, false, true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
	/**
	 * Тест, проверяющий матрицу 4х4. По одной диагонали - все true, по другой - true, false, false, false, результат  - false. 
	 */
    @Test
    public void whenDataNotMonoByTrueThenFalseEven() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, true},
                {false, true, false, true},
                {true, false, true, false},
				{false, false, true, true},
		};
        boolean result = check.mono(input);
        assertThat(result, is(false));

    }
}
			