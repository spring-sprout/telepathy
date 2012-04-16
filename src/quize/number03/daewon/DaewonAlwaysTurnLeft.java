package quize.number03.daewon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DaewonAlwaysTurnLeft {

	public static final char FORWARD = 'W';
	public static final char TURN_LEFT = 'L';
	public static final char TURN_RIGHT = 'R';

	public String solve(String input) {
		Maze maze = new Maze();

		String[] paths = input.split(" ");
		String entrance2Exit = paths[0];
		String exit2Entrance = paths[1];

		Mouse mouse = new Mouse();
		navigateMaze(maze, mouse, entrance2Exit);
		mouse.reverse();
		navigateMaze(maze, mouse, exit2Entrance);

		return maze.toString();
	}

	private void navigateMaze(Maze maze, Mouse mouse, String path) {
		for (int i = 0; i < path.length(); i++) {
			char action = path.charAt(i);
			switch (action) {
			case FORWARD:
				mouse.forward();
				int row = mouse.getRow();
				if (row == 0 || i == (path.length() - 1))
					break;

				int col = mouse.getColumn();
				Direction direction = mouse.getDirection().reverse();
				MazeCell cell = maze.getCell(row, col);
				cell.open(direction);
				break;

			case TURN_LEFT:
				mouse.turnLeft();
				break;

			case TURN_RIGHT:
				mouse.turnRight();
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("/B-large-practice.out");
		BufferedReader reader = new BufferedReader(new FileReader("/B-large-practice.in"));

		DaewonAlwaysTurnLeft atl = new DaewonAlwaysTurnLeft();
		int inputCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < inputCount; i++) {
			String result = atl.solve(reader.readLine());
			writer.write(String.format("Case #%d:\n%s", i + 1, result));
		}

		writer.close();
		reader.close();

	}
}
