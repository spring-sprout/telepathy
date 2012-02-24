package chapter3.quicksort;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaegyuQuickSortTest {
	
	@Test
	public void testQuickSort() throws Exception {
		int[] input  = new int[]{31,3,65,73,8,11,20,29,48,15};
		int[] result = new int[]{3,8,11,15,20,29,31,48,65,73};
		
		JaegyuQuickSort quiceSort = new JaegyuQuickSort();
		
		assertArrayEquals(result, quiceSort.sort(input));
	}
	
	@Test
	public void testQuickSort2() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuQuickSort quiceSort = new JaegyuQuickSort();
		
		assertArrayEquals(result, quiceSort.sort(input));
	}
	
	@Test
	public void testQuickSort3() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{1,2,3};
		
		JaegyuQuickSort quiceSort = new JaegyuQuickSort();
		
		assertArrayEquals(result, quiceSort.sort(input));
	}
}
