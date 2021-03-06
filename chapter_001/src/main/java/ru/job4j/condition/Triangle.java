package ru.job4j.condition;

/**
 * Вычисление площади треугольника по формуле Герона.
 *
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.11
 */
 
public class Triangle {
/**
 *Задание трёх точек треугольника (a, b, c) через использование класса Point.
 */
   private Point a;
   private Point b;
   private Point c;
/** 
*Конструктор для инициализации переменных a, b, c cсылочного типа Point.
*@param a, b, c - точки треугольника.
*/
   public Triangle(Point a, Point b, Point c) {
       this.a = a;
       this.b = b;
       this.c = c;
    }

/**
* Метод вычисления полупериметра по длинам сторон.
*
* Формула.
*
* (ab + ac + bc) / 2
*
* @param ab - расстояние между точками a b
* @param ac - расстояние между точками a c
* @param bc - расстояние между точками b c
* @return - полупериметр.
*/
public double period(double ab, double ac, double bc) {
    return (ab + ac + bc) / 2;
}
/**
* Метод вычисления площади треугольника по формуле Герона.
*
* @return возвращает прощадь, если треугольник существует или -1, если треугольника нет.
*/
public double area() {
    double rsl = -1;
    double ab = this.a.distanceTo(this.b);
    double ac = this.a.distanceTo(this.c);
    double bc = this.b.distanceTo(this.c);
    double p = this.period(ab, ac, bc);
    if (this.exist(ab, ac, bc)) {
       rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
    }
    return rsl;
}
/**
* Метод проверяет можно ли построить треугольник с такими длинами сторон.
* 
* Условие НЕсуществования треугольника: сумма двух сторон должна быть равна длине третьей стороны.
* 
* @param ab Длина от точки a до b. 
* @param ac Длина от точки a до c.
* @param bc Длина от точки b до c.
* @return triangle=false, если треугольника нет
*/
private boolean exist(double ab, double ac, double bc) {
	return   ((ab + ac) > bc && (ab + bc) > ac && (bc + ac) > ab);
	}
}
