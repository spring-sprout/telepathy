package quize.number02;

import junit.framework.Assert;

import org.junit.Test;

public class DaewonAlienNumberTest {

	DaewonAlienNumber number = new DaewonAlienNumber();

	@Test
	public void testSolve() {
//		Assert.assertEquals("Foo", number.solve("9 0123456789 oF8"));
//		Assert.assertEquals("9", number.solve("Foo oF8 0123456789"));
		Assert.assertEquals("10011", number.solve("13 0123456789abcdef 01"));
		Assert.assertEquals("JAM!", number.solve("CODE O!CDE? A?JM!."));
	}


	@Test
	public void testToDecimal() {
		Assert.assertEquals(9, number.toDecimal("9", "0123456789"));
		Assert.assertEquals(9, number.toDecimal("Foo", "oF8"));
		Assert.assertEquals(9, number.toDecimal("1001", "01"));
	}


}
