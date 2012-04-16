package quize.number03.daewon;

public class MazeCell {

	int value = 0x0;

	public MazeCell() {
		super();
	}

	public MazeCell(int value) {
		this.value = value;
	}

	public int getNumber() {
		return value;
	}

	public String getHex() {
		return String.format("%x", value);
	}

	public void open(Direction direction) {
		value = value | direction.getValue();
	}

	public void openNorth() {
		open(Direction.NORTH);
	}

	public void openSouth() {
		open(Direction.SOUTH);
	}

	public void openWest() {
		open(Direction.WEST);
	}

	public void openEast() {
		open(Direction.EAST);
	}
}
