package chapter3;

import static org.junit.Assert.*;
import org.junit.Test;


public class SortUtilTest {
	@Test
	public void testSwap(){
		int[] actualIntArray = {4, 1, 2};
		int[] expectIntArray = {4, 2, 1};
		
		SortUtil.swap(actualIntArray, 1, 2);
		
		assertArrayEquals(expectIntArray,  actualIntArray);
		
		actualIntArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		expectIntArray = new int[]{10, 2, 3, 4, 5, 6, 7, 8, 9, 1};
		
		SortUtil.swap(actualIntArray, 0, 9);
		assertArrayEquals(expectIntArray, actualIntArray);
		
		// 예외 테스트
		try{
			int[] illegalIntArray = null;
			SortUtil.swap(illegalIntArray, 0, 1);
			fail();
		}catch(NullPointerException ex){}
		
		try{
			SortUtil.swap(actualIntArray, 0, actualIntArray.length + 4);
			fail();
		}catch (IllegalArgumentException ex) {}
		
		try{
			SortUtil.swap(actualIntArray, actualIntArray.length + 4, 0);
			fail();
		}catch (IllegalArgumentException ex) {}
		
		try{
			SortUtil.swap(actualIntArray, -1, 0);
			fail();
		}catch (IllegalArgumentException ex) {}
		
		try{
			SortUtil.swap(actualIntArray, 0, -1);
			fail();
		}catch (IllegalArgumentException ex) {}
	}
	
	@Test
	public void testValid(){
		try{
			SortUtil.valid(null);
			fail();
		}catch(IllegalArgumentException ex){}
		
		try{
			SortUtil.valid(new int[]{});
			fail();
		}catch(IllegalArgumentException ex){}
	}
	
	@Test
	public void testReverse(){
		int[] actualIntArray = {1, 2, 3, 4, 5};
		int[] expectedIntArray = {5, 4, 3, 2, 1};
		SortUtil.reverse(actualIntArray);
		assertArrayEquals(expectedIntArray, actualIntArray);
	}
}
