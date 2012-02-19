package quize.number01;

/**
 * @author ihseo
 */
public class ILhyunRankService implements RankingService {
	private int maxIndex = 100;

	@Override
	public int[] rank(int[] scores) {
		int size = scores.length;

		int[] tempScore = new int[maxIndex+1];
		int[] ranks = new int[size];
		
		for(int loop=0; loop < size; loop++){
			tempScore[scores[loop]] = 1;
		}
		
		int rank = 0;
		for(int loop=maxIndex; loop >= 0; loop--){
			rank += tempScore[loop];
//			System.out.println(loop + " : " + rank);
			tempScore[loop] = rank;
		}
		
		for(int loop = 0; loop < size; loop++){
			ranks[loop] = tempScore[scores[loop]];
		}
		
		return ranks;
	}

}