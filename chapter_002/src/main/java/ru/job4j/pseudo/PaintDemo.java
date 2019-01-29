package ru.job4j.pseudo;

/**
 * Класс PaintDemo - реализация вывода информации в консоль.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.29
 */

public class PaintDemo {

	public static void main(String[] args) {
//вывод на экран квадрата и треугольника.
		Square square = new Square();
		System.out.println(square.draw());
		Triangle triangle = new Triangle();
		System.out.println(triangle.draw());
		
		Paint paint = new Paint();
		paint.draw(new Triangle());
		paint.draw(new Square());
	}
}