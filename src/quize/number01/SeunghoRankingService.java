package quize.number01;

public class SeunghoRankingService implements RankingService {

	@Override
	public int[] rank(int[] scores) {
		int veryBigArraySize = 100;
		int[] rankingIndex = new int[veryBigArraySize];
		int[] rankings = new int[scores.length];

		for(int i = 0 ; i < scores.length ; i++) {
			rankingIndex[scores[i]-1] += 1;
		}

		for(int i = 0 ; i < scores.length ; i++) {
			int num = scores[i];
			int rank = 1;

			for(int j = veryBigArraySize ; j > num ; j--) {
				rank += rankingIndex[j-1];
			}
			rankings[i] = rank;
		}

		return rankings;
	}

}
