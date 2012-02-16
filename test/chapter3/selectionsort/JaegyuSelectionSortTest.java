package chapter3.selectionSort;

import static org.junit.Assert.*;

import org.junit.Test;


public class JaegyuSelectionSortTest {
	
	@Test
	public void testSelectionSort() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuSelectionSort selection = new JaegyuSelectionSort();
		assertArrayEquals(result, selection.sort(input));
	}
	
	
	@Test
	public void testSelectionSort2() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{1,2,3};
		
		JaegyuSelectionSort selection = new JaegyuSelectionSort();
		assertArrayEquals(result, selection.sort(input));
	}
	
	@Test
	public void theLargest() throws Exception {
		int[] input = new int[]{1,2,3};
		
		JaegyuSelectionSort selection = new JaegyuSelectionSort();
		assertEquals(2, selection.returnMaxIndex(input,2));
	}
	
	@Test
	public void theLargest2() throws Exception {
		int[] input = new int[]{4,2,3};
		
		JaegyuSelectionSort selection = new JaegyuSelectionSort();
		assertEquals(0, selection.returnMaxIndex(input,2));
	}
	
	@Test
	public void theLargest3() throws Exception {
		int[] input = new int[]{4,2,3,6,7,8,9};
		
		JaegyuSelectionSort selection = new JaegyuSelectionSort();
		assertEquals(6, selection.returnMaxIndex(input,6));
	}
	
	@Test
	public void testSwap() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{2,1,3};
		
		JaegyuSelectionSort selection = new JaegyuSelectionSort();
		assertArrayEquals(result, selection.swap(input,0,1));
	}
}
