package quize.number03.daewon;

public class Mouse {

	private Direction direction = Direction.SOUTH;
	private int numOfColumn = 0;
	private int numOfRow = 0;
	private int row = 0;
	private int column = 0;

	public Mouse() {}

	public Mouse(Direction direction) {
		this.direction = direction;
	}

	public void forward() {
		switch (direction) {
		case NORTH:
			row--;
			break;
		case EAST:
			column++;
			break;
		case SOUTH:
			row++;
			break;
		case WEST:
			column--;
			break;
		default:
			break;
		}

		numOfColumn = Math.max(Math.abs(column), numOfColumn);
		numOfRow = Math.max(Math.abs(row), numOfRow);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Direction reverse() {
		turnLeft();
		return turnLeft();
	}

	public Direction turnLeft() {
		if (direction == Direction.NORTH) {
			this.direction = Direction.WEST;

		} else if (direction == Direction.WEST) {
			this.direction = Direction.SOUTH;

		} else if (direction == Direction.SOUTH) {
			this.direction = Direction.EAST;

		} else if (direction == Direction.EAST) {
			this.direction = Direction.NORTH;

		}

		return this.direction;
	}

	public Direction turnRight() {
		if (direction == Direction.NORTH) {
			this.direction = Direction.EAST;

		} else if (direction == Direction.EAST) {
			this.direction = Direction.SOUTH;

		} else if (direction == Direction.SOUTH) {
			this.direction = Direction.WEST;

		} else if (direction == Direction.WEST) {
			this.direction = Direction.NORTH;
		}

		return this.direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getNumOfRow() {
		return numOfRow;
	}

	public int getNumOfColumn() {
		return numOfColumn;
	}

}
