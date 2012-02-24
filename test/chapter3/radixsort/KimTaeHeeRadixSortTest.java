package chapter3.radixsort;

import static chapter3.AssertSortUtil.*;
import org.junit.Test;

import chapter3.Sort;


public class KimTaeHeeRadixSortTest {
	Sort radixSort = new KimTaeHeeRadixSort();
	
	@Test
	public void testSort(){
		int[] actualIntArray = {234, 4412, 135, 10,  23, 1231, 1111, 9999, 8888, 6746};
		radixSort.sort(actualIntArray);
		assertSort(actualIntArray);
	}
}
