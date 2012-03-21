package chapter3.mergesort;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaegyuMergeSortTest {
	
	@Test
	public void testMergeSort() throws Exception {
		int[] input  = new int[]{31,3,65,73,8,11,20,29,48,15};
		int[] result = new int[]{3,8,11,15,20,29,31,48,65,73};
		
		JaegyuMergeSort mergeSort = new JaegyuMergeSort();
		
		assertArrayEquals(result, mergeSort.sort(input));
	}
	
	@Test
	public void testMergeSort2() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuMergeSort mergeSort = new JaegyuMergeSort();
		
		assertArrayEquals(result, mergeSort.sort(input));
	}
	
	@Test
	public void testMergeSort3() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{1,2,3};
		
		JaegyuMergeSort mergeSort = new JaegyuMergeSort();
		
		assertArrayEquals(result, mergeSort.sort(input));
	}
}
