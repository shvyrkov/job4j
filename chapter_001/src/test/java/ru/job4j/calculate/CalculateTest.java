package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
* @version 1.0
* @since 2018.09.16
*/
public class CalculateTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Yuri Shvyrkov";
    String expect = "Echo, echo, echo : Yuri Shvyrkov"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}