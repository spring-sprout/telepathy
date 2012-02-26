package chapter4;

import junit.framework.Assert;

import org.junit.Test;

public class DaewonAverageLinearTimeSelectTest {

	DaewonAverageLinearTimeSelect select = new DaewonAverageLinearTimeSelect();
	int[] input;

	@Test
	public void test() {
		input = new int[] { 5, 2, 3, 4, 1, 10 };
		Assert.assertEquals(3, select.select(input, 3));

		input = new int[] { 5, 4, 3, 2, 1, 10 };
		Assert.assertEquals(5, select.select(input, 5));

		input = new int[] { 1, 2, 2, 3, 3, 4, 5, 10 };
		Assert.assertEquals(3, select.select(input, 4));
	}

}
