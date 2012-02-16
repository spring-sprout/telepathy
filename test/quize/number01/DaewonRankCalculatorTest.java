package quize.number01;

import org.junit.Assert;
import org.junit.Test;

public class DaewonRankCalculatorTest {

	DaewonRankingCalculator rankingCalculator = new DaewonRankingCalculator();

	@Test
	public void testGetRanking() {
		int[] scores = new int[] { 80, 80, 60, 100 };
		int[] ranking = rankingCalculator.getRanking(scores);

		Assert.assertEquals(2, ranking[0]);
		Assert.assertEquals(2, ranking[1]);
		Assert.assertEquals(4, ranking[2]);
		Assert.assertEquals(1, ranking[3]);
	}

	@Test
	public void testPringRanking() {
		int[] scores = new int[] { 80, 80, 60, 100 };
		rankingCalculator.printRanking(scores);
	}
}
