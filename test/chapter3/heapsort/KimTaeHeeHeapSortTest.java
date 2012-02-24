package chapter3.heapsort;

import static chapter3.AssertSortUtil.*;

import org.junit.Test;

import chapter3.Sort;


public class KimTaeHeeHeapSortTest {
	Sort heapSort = new KimTaeHeeHeapSort();
	
	@Test
	public void testSort(){
		int[] actualIntArray = {9, 4, 5, 4, 3, 2, 1};
		heapSort.sort( actualIntArray );
		assertSort( actualIntArray );
	}
}
