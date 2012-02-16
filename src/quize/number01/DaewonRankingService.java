package quize.number01;

public class DaewonRankingService implements RankingService {

	@Override
	public int[] rank(int[] scores) {
		int[] ranking = new int[scores.length];

		for (int i = 0; i < scores.length; i++) {
			int value = scores[i];
			int rank = 1;
			for (int j = 0; j < scores.length; j++) {
				rank += (value < scores[j] ? 1 : 0);
			}

			ranking[i] = rank;
		}

		return ranking;
	}

	public void printRanking(int[] scores) {
		int[] ranking = rank(scores);
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d %d %d\n", i, scores[i], ranking[i]);
		}
	}
}
