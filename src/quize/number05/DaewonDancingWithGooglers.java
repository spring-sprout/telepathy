package quize.number05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DaewonDancingWithGooglers {

	public static final int NUM_OF_JUDGE = 3;

	public int solve(String input) {

		int result = 0;

		String[] datas = input.split(" ");
		int numOfGoogler = Integer.parseInt(datas[0]);
		int numOfSuprising = Integer.parseInt(datas[1]);
		int minOfBest = Integer.parseInt(datas[2]);

		for (int i = 0; i < numOfGoogler; i++) {
			int sumOfScore = Integer.parseInt(datas[i + 3]);
			int avg = sumOfScore / NUM_OF_JUDGE;
			int mod =sumOfScore % NUM_OF_JUDGE;

			if (avg >= minOfBest) {
				result++;

			} else if (avg == (minOfBest - 1)) {
				if (mod != 0) {
					result++;

				} else if (sumOfScore > 0 && numOfSuprising > 0) {
					result++;
					numOfSuprising--;
				}

			} else if (avg == (minOfBest - 2) && mod == 2 && numOfSuprising > 0) {
				result++;
				numOfSuprising--;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("/B-large-practice.out");
		BufferedReader reader = new BufferedReader(new FileReader("/B-large-practice.in"));

		long startTime = System.currentTimeMillis();
		System.out.println("Start to solve google code jam problem");
		DaewonDancingWithGooglers solution = new DaewonDancingWithGooglers();
		int inputCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < inputCount; i++) {
			int result = solution.solve(reader.readLine());
			writer.write(String.format("Case #%d: %s\n", i + 1, result));
		}
		System.out.printf("End to solve google code jam problem [ElapsedTime:%d]\n", (System.currentTimeMillis() - startTime));

		writer.close();
		reader.close();

	}

}
