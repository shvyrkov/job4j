/**
* Calculate - класс для вывода на экран надписи "Hello World".
*
* @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
* @version 1.0
* @since 2018.09.16
*/
package ru.job4j.calculate;

 public class Calculate {
/**
*Main.
*@param args - letters.
*/
  public static void main(String[] args)  {

	System.out.println("Hello World");
	}
	/**
* Method echo.
* @param name Yuri Shvyrkov.
* @return Echo plus Yuri Shvyrkov.
*/
public String echo(String name) {
    return "Echo, echo, echo : " + name;
}
 }