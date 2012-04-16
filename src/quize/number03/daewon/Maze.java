package quize.number03.daewon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Maze {
	int columnSize;
	int rowSize;
	List<MazeRow> rows = new ArrayList<MazeRow>();

	public void setRow(int rowIdx, MazeRow row) {
		rows.set(rowIdx, row);
	}

	public void setCell(int row, int col, MazeCell cell) {
		rows.get(row).setColumn(col, cell);
	}

	public MazeRow getRow(int row) {
		int addRowCount = row - rows.size();
		for (int i = 0; i < addRowCount; i++) {
			MazeRow mazeRow = new MazeRow();
			rows.add(mazeRow);
		}

		return rows.get(row);
	}

	public MazeCell getCell(int row, int col) {
		int addRowCount = row - rows.size();
		for (int i = 0; i < addRowCount; i++) {
			MazeRow mazeRow = new MazeRow();
			rows.add(mazeRow);
		}

		return rows.get(row - 1).getCol(col);
	}

	public int getRowSize() {
		return rows.size();
	}

	public String toString() {
		StringBuilder strBuf = new StringBuilder(columnSize * rowSize);
		for (MazeRow row : rows) {
			Map<Integer, MazeCell> columns = row.getColumns();

			Set<Integer> keySet = columns.keySet();
			List<Integer> idxs = new ArrayList<Integer>();
			for (Integer colIdx : keySet) {
				idxs.add(colIdx);
			}

			Collections.sort(idxs);
			for (Integer colIdx : idxs) {
				strBuf.append(columns.get(colIdx).getHex());
			}
			strBuf.append("\n");
		}

		return strBuf.toString();
	}

}