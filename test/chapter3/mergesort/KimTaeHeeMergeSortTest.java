package chapter3.mergesort;

import static chapter3.AssertSortUtil.assertSort;

import org.junit.Test;

import chapter3.Sort;


public class KimTaeHeeMergeSortTest {
	Sort mergeSort = new KimTaeHeeMergeSort();
	
	@Test
	public void testSort(){
		int[] actualIntArray = {5, 4, 3, 2, 1};
		mergeSort.sort( actualIntArray );
		assertSort(actualIntArray);
	}
}
