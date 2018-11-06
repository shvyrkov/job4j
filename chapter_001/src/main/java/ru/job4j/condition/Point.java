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
* @return result - расстояние до заданной точки
*/		
	public double distanceTo(Point that) {
//Точка А - текущая точка. К ней мы обращаемся через оператор this.
		Point a = this;
//Точка В - это входящая точка. К ней мы можем обратиться напрямую через имя переменной that.
		Point b = that;
//Задание координат текущей точки а.    
		int x1 = a.x;
		int y1 = a.y;
//Задание координат входящей точки b. 		
		int x2 = b.x;
		int y2 = b.y;
//Вычисление расстояния между точками.		
    return Math.sqrt(
            Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
		);
	}
	
	public static void main(String[] args) {
//Определение объектов a и b с заданными координатами.
		Point a = new Point(0, 1);
		Point b = new Point(2, 5);
// Вывод на консоль координат точек a и b.
		System.out.println("x1 = " + a.x);
		System.out.println("y1 = " + a.y);
		System.out.println("x2 = " + b.x);
		System.out.println("y2 = " + b.y);
//Вызов метода для определения расстояния между точками и его вывод на консоль.
    double result = a.distanceTo(b);
//    System.out.println("Расстояние между точками А и В : " + result);
		System.out.print("Distance between A and B : " + result);
 	}
	
	}