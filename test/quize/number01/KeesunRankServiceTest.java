package quize.number01;

import org.junit.Test;

/**
 * @author Keesun Baik
 */
public class KeesunRankServiceTest {
	
	@Test
	public void rank(){
		RankingService rankingService = new KeesunRankService();
		int[] rankings = rankingService.rank(new int[]{5, 1, 2, 2});
		System.out.println("======================");
		for(int i : rankings) {
			System.out.println(i);
		}

	}
	
}
