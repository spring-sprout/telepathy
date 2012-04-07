package quize.number03.keesun;

/**
 * @author Keesun Baik
 */
public class Cell {

	private boolean enableE;

	private boolean enableW;

	private boolean enableS;

	private boolean enableN;
	
	private int row;
	
	private int column;

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public boolean isEnableE() {
		return enableE;
	}

	public boolean isEnableW() {
		return enableW;
	}

	public boolean isEnableS() {
		return enableS;
	}

	public boolean isEnableN() {
		return enableN;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void diable(Direction direction) {
		switch (direction) {
			case E: this.enableE = false; break;
			case W: this.enableW = false; break;
			case S: this.enableS = false; break;
			case N: this.enableN = false; break;
		}
	}

	public void moveRight() {
		this.column += 1;
	}

}
