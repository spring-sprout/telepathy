package quize.number01;

public class ILhyunRankService implements RankingService {
	private int maxIndex = 100;

	@Override
	public int[] rank(int[] scores) {
		int startIndex = maxIndex-1;
		int lastIndex = 0;
		int size = scores.length;

		int[] tempScore = new int[maxIndex];
		int[] ranks = new int[size];
		
		for(int loop=0; loop < size; loop++){
			tempScore[scores[loop]-1] = 1;
		}
		
		for(int loop=0; loop < size; loop++){
			lastIndex = scores[loop]-1;
			
			int rank = 1;
			
			for(int inLoop = startIndex; inLoop > lastIndex; inLoop--){
				rank += tempScore[inLoop];
			}
			ranks[loop] = rank;
		}
		
		return ranks;
	}

}