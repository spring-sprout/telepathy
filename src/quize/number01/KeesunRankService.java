package quize.number01;

/**
 * @author Keesun Baik
 */
public class KeesunRankService implements RankingService{

	@Override
	public int[] rank(int[] scores) {
		int veryBigArraySize = 100;
		int[] rankingIndex = new int[veryBigArraySize];
		int[] rankings = new int[scores.length];

		for(int i = 0 ; i < scores.length ; i++) {
                            //제가 입력값 조건을 잘못 알고있는지 
                           //이 부분에서 만약 점수가 0점이 들어온다면.. ?
                           //-1이 되며로 에러가 날것 같습니다.
			rankingIndex[scores[i]-1] += scores[i];
		}

		for(int i = 0 ; i < scores.length ; i++) {
			int num = scores[i];
			int rank = 1;
//			System.out.println("num: " + num);
			for(int j = 1 ; j < num ; j++) {
//				System.out.println("j: " + j);
//				System.out.println("rankingIndex[j-1]: " + rankingIndex[j-1]);
				rank += rankingIndex[j-1]/j;
//				System.out.println("rank: " + rank);
			}
			rankings[i] = rank;
		}

		return rankings;
	}
}
