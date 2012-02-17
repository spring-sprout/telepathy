package quize.number01;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author Keesun Baik
 */
public class SeunghoRankServiceTest {

	@Test
	public void rank() {
		RankingService rankingService = new SeunghoRankingService();
		int[] rankings = rankingService.rank(new int[] { 80, 100, 80, 1 });
		assertArrayEquals(rankings, new int[] { 2, 1, 2, 4 });
	}

}
