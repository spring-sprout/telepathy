package chapter3.insertionsort;

import static org.junit.Assert.*;

import org.junit.Test;


public class JaegyuInsertionSortTest {
	@Test
	public void testInsertionSort1() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuInsertionSort insertionSort = new JaegyuInsertionSort();
		assertArrayEquals(result, insertionSort.sort(input));
	}
	
	@Test
	public void testInsertionSort2() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{1,2,3};
		
		JaegyuInsertionSort insertionSort = new JaegyuInsertionSort();
		assertArrayEquals(result, insertionSort.sort(input));
	}
}
