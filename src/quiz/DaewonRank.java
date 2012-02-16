package quiz;

public class DaewonRank {

	public void printRanking(int[] scores) {
		for (int i = 0; i < scores.length; i++) {
			int value = scores[i];
			int rank = 1;
			for (int j = 0; j < scores.length; j++) {
				rank += (value < scores[j] ? 1 : 0);
			}

			System.out.printf("%d %d %d\n", i, value, rank);
		}
	}

	public static void main(String[] args) {
		new DaewonRank().printRanking(new int[] { 80, 80, 60, 100 });
	}
}
