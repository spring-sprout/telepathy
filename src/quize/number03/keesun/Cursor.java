package quize.number03.keesun;

/**
 * @author Keesun Baik
 */
public class Cursor {

	public void entrance(Action w, Cursor reversedCursor) {
		if(reversedCursor == null) {
			action(w);
		} else {
			this.direction = reversedCursor.getDirection().right.right;
			action(w);
		}
	}

	public void exit(Action w) {

	}

	static enum Action {
		W, L, R;
	}

	private Direction direction = Direction.S; //북쪽에서 진입하니까 기본 방향은 남쪽.

	private Maze maze;

	private Cell cell;

	public Cursor() {
		this.maze = new Maze();
	}

	public void action(Action action) {
		switch (action) {
			case L: turnLeft(); break;
			case R: turnRight(); break;
			case W: doW(); break;
		}
	}

	private void doW() {
		this.cell = this.maze.nextCell(this.cell, this.direction);
	}

	private void turnRight() {
		blockFront();
		blockLeft();
		this.direction = this.direction.getRight();
	}

	private void turnLeft() {
		blockFront();
		this.direction = this.direction.getLeft();
	}

	private void blockLeft() {
		this.cell.diable(this.direction.getLeft());
	}

	private void blockFront() {
		this.cell.diable(this.direction);
	}

	public Direction getDirection() {
		return direction;
	}

	public Maze getMaze() {
		return maze;
	}

	public Cell getCell() {
		return cell;
	}
}
