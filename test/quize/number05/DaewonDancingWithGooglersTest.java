package quize.number05;

import org.junit.Assert;
import org.junit.Test;

public class DaewonDancingWithGooglersTest {

	@Test
	public void test() {
		DaewonDancingWithGooglers solution = new DaewonDancingWithGooglers();

		Assert.assertEquals(3, solution.solve("3 1 5 15 13 11"));
		Assert.assertEquals(2, solution.solve("3 0 8 23 22 21"));
		Assert.assertEquals(1, solution.solve("2 1 1 8 0"));
		Assert.assertEquals(3, solution.solve("6 2 8 29 20 8 18 18 21"));
		Assert.assertEquals(1, solution.solve("2 2 3 5 4"));
	}
}
