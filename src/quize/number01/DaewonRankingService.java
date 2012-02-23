package quize.number01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaewonRankingService implements RankingService {

	private List<List<Integer>> scoreStoreList;
	private Map<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();

	public DaewonRankingService() {
		scoreStoreList = new ArrayList<List<Integer>>(101);
		for (int i = 0; i < 101; i++) {
			scoreStoreList.add(new ArrayList<Integer>());
		}
	}

	/**
	 * Radix 정렬 알고리즘에서 힌트를 얻어서 퀴즈문제를 풀었다
	 * 그런데 풀고나서 기선님 풀이와 비교하니 별반 드릴게 없는 것 같다. ㅡㅡ;;
	 * 마지막 정렬 알고리즘을 공부하면 O(n)의 복잡도를 갖는 알고리즘을 알 수 있을까???
	 */
	@Override
	public int[] rank(int[] scores) {
		int[] ranking = new int[scores.length];

		for (int i = 0; i < scores.length; i++) {
			int score = scores[i];
			scoreStoreList.get(score).add(score);
		}

		int rank = 1;
		for(int i = scoreStoreList.size()-1; i >= 0; i--) {
			List<Integer> scoreStore = scoreStoreList.get(i);
			for (Integer score : scoreStore) {
				rankingMap.put(score, rank);
				System.out.printf("Score:%d, Rank:%d\n", score, rank);
				rank += scoreStore.size();
				break;
			}

		}

		for (int i = 0; i < scores.length; i++) {
			int score = scores[i];
			ranking[i] = rankingMap.get(score);
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
