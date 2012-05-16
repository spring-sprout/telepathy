package quize.number03.daewon;

import java.util.HashMap;
import java.util.Map;

public class MazeRow {
	Map<Integer, MazeCell> columns = new HashMap<Integer, MazeCell>();

	public MazeRow() {}

	public void setColumn(int col, MazeCell cell) {
		columns.put(col, cell);
	}

	public MazeCell getCol(int col) {
		MazeCell cell = columns.get(col);
		if (cell == null) {
			cell = new MazeCell();
			columns.put(col, cell);
		}

		return cell;
	}

	public Map<Integer, MazeCell> getColumns() {
		return columns;
	}

	public int getColumnSize() {
		return columns.size();
	}

}
