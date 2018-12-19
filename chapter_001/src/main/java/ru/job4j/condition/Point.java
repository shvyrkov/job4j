 package ru.job4j.condition;

/**
 * Задание точки в системе координат и вычисление расстояние до другой точки.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.06
 */
 
public class Point {
/**
* Координаты точки.
*/
	private int x;
	private int y;
	
/** 
*Конструктор для инициализации х и у.
*@param x - координата х
*@param y - координата у
*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		}
		
/**
* Метод для расчёта расстояния от текущей точки до заданной.
* @param that - заданная точка типа Point
* @return - расстояние до заданной точки
*/		
	public double distanceTo(Point that) {
		return Math.sqrt(
            Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
		);
	}
	public static void main(String[] args) {
		Point a = new Point(0, 3);
		Point b = new Point(4, 0);
		System.out.println("x1 = " + a.x);
		System.out.println("y1 = " + a.y);
		System.out.println("x2 = " + b.x);
		System.out.println("y2 = " + b.y);
    double result = a.distanceTo(b);
		System.out.print("Distance between A and B : " + result);
 	}
}