package chapter3.countingsort;

import static chapter3.AssertSortUtil.*;
import static org.junit.Assert.*;

import org.junit.Test;

import chapter3.Sort;


public class KimTaeHeeCountingSortTest {

	Sort countingSort = new KimTaeHeeCountingSort();
	
	@Test
	public void testSort(){
		int[] actualIntArray = {7, 12, 31, 1, 22, 1};
		countingSort.sort(actualIntArray);
		assertSort( actualIntArray );
		
		// 잘못된 배열 인자일 때 테스트
		try{
			countingSort.sort(null);
			fail();
		}catch(IllegalArgumentException ex){}
		
		try{
			countingSort.sort(new int[]{});
			fail();
		}catch(IllegalArgumentException ex){}
	}
}
