package quize.number01;

/**
 * @author ihseo
 */
public class ILhyunRankService implements RankingService {
	private int maxIndex = 100;

	@Override
	public int[] rank(int[] scores) {
		int startIndex = maxIndex;
		int lastIndex = 0;
		int size = scores.length;

		int[] tempScore = new int[maxIndex+1];
		int[] ranks = new int[size];
		
		for(int loop=0; loop < size; loop++){
			tempScore[scores[loop]] = 1;
		}
		
		for(int loop=0; loop < size; loop++){
			lastIndex = scores[loop];
			
			int rank = 1;
			
			for(int inLoop = startIndex; inLoop > lastIndex; inLoop--){
				rank += tempScore[inLoop];
			}
			ranks[loop] = rank;
		}
		
		return ranks;
	}

}