package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
* @version 1.0
* @since 2018.09.18
*/
public class HelloWorldTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Yuri Shvyrkov";
    String expect = "Echo, echo, echo : Yuri Shvyrkov"; 
    package ru.job4j.calculate;

    public class HelloWorld {
        private double result;

        public void add(double first, double second) {
            this.result = first + second;
        }

        public double getResult() {
            return this.result;
        }
    }
    HelloWorld calc = new HelloWorld();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}