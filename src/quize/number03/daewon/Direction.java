package quize.number03.daewon;

public enum Direction {

	NORTH(1), SOUTH(2), WEST(4), EAST(8);

	final int value;

	private Direction(int value) {
		this.value = value;
	}

	public Direction reverse() {
		switch (this) {
		case NORTH:
			return SOUTH;
		case SOUTH:
			return NORTH;
		case EAST:
			return WEST;
		case WEST:
			return EAST;
		default:
			return null;
		}
	}

	public int getValue() {
		return value;
	}

	public Direction valueOf(int value) {
		switch (value) {
		case 1:
			return NORTH;
		case 2:
			return SOUTH;
		case 4:
			return WEST;
		case 8:
			return EAST;
		default:
			throw new IllegalArgumentException(String.format("Invalid Value [Expected:1,2,4,8] [Arg:%d]", value));
		}
	}
}
