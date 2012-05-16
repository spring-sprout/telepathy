package quize.number03.daewon;

import junit.framework.Assert;

import org.junit.Test;

public class DaewonAlwaysTurnLeftTest {

	DaewonAlwaysTurnLeft atl = new DaewonAlwaysTurnLeft();

	@Test
	public void test() {
		String result = atl.solve("WRWWLWWLWWLWLWRRWRWWWRWWRWLW WWRRWLWLWWLWWLWWRWWRWWLW");
		Assert.assertEquals("ac5\n386\n9c7\ne43\n9c5\n", result);

		result = atl.solve("WW WW");
		Assert.assertEquals("3\n", result);
	}
}
