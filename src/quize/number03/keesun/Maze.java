package quize.number03.keesun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Keesun Baik
 */
public class Maze {

	private List<List<Cell>> cells = new ArrayList<List<Cell>>();

	public Cell nextCell(Cell prevCell, Direction direction) {
		Cell cell = null;
		if(prevCell == null) {
			cell = getCell(0, 0);
		} else {
			switch (direction) {
				case E:
					cell = getCell(prevCell.getRow(), prevCell.getColumn() + 1);
					break;
				case W:
					cell = getCell(prevCell.getRow(), prevCell.getColumn() - 1);
					break;
				case S:
					cell = getCell(prevCell.getRow() + 1, prevCell.getColumn());
					break;
				case N:
					cell = getCell(prevCell.getRow() - 1, prevCell.getColumn());
					break;
			}
		}
		return cell;
	}

	private Cell getCell(int r, int c) {
		if(c == -1) {
			moveAllCellsToRight();
			c = 0;
		}

		if(r == -1) {
			// IS THIS POSSIBLE?
		}

		List<Cell> row = null;
		if(cells.size() < r + 1) {
			row = new ArrayList<Cell>();
			cells.add(r, row);
		} else {
			row = cells.get(r);
		}

		Cell cell = null;
		if(row.size() < c + 1) {
			cell = new Cell(r, c);
			row.add(c, cell);
		}
		return cell;
	}

	private void moveAllCellsToRight() {
		for(List<Cell> row : cells) {
			for(Cell column : row) {
				row.set(column.getColumn()+1, column);
				row.set(column.getColumn(), null);
				column.moveRight();
			}
		}
	}

	public List<List<Cell>> getCells() {
		return cells;
	}
}
