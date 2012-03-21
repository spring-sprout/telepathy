package chapter3.heapsort;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaegyuHeapSortTest {

	@Test
	public void testHeapSort() throws Exception {
		int[] input  = new int[]{31,3,65,73,8,11,20,29,48,15};
		int[] result = new int[]{3,8,11,15,20,29,31,48,65,73};
		
		JaegyuHeapSort heapsort = new JaegyuHeapSort();
		
		assertArrayEquals(result, heapsort.sort(input));
	}
	
	@Test
	public void testHeapSort2() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuHeapSort heapsort = new JaegyuHeapSort();
		
		assertArrayEquals(result, heapsort.sort(input));
	}
	
	@Test
	public void testHeapSort3() throws Exception {
		int[] input  = new int[]{2,3,4};
		int[] result = new int[]{2,3,4};
		
		JaegyuHeapSort heapsort = new JaegyuHeapSort();
		
		assertArrayEquals(result, heapsort.sort(input));
	}
}
