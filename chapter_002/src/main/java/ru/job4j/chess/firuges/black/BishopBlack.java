package ru.job4j.chess.firuges.black;

import ru.job4j.chess.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Класс BishopBlack - движение черного слона.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.03.11
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
		int deltaX = dest.x - source.x;
		int deltaY = dest.y - source.y;
		//Дельты движения слона должны быть равны по модулю.
        if (!(Math.abs(deltaX) == Math.abs(deltaY))) {
			throw new ImposibleMoveException("Так слон не ходит");
		}
        steps = new Cell[] { dest };
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
