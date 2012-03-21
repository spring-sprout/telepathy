package chapter3.bubblesort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author JaeGyu
 */
public class JaegyuBubbleSortTest {
	@Test
	public void testSort() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuBubbleSort bubbleSort = new JaegyuBubbleSort();
		assertArrayEquals(result, bubbleSort.sort(input));
	}
	
	@Test
	public void testSort2() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{1,2,3};
		
		JaegyuBubbleSort bubbleSort = new JaegyuBubbleSort();
		assertArrayEquals(result, bubbleSort.sort(input));
	}
	
	@Test
	public void testImprovedSort1() throws Exception {
		int[] input  = new int[]{3,2,1};
		int[] result = new int[]{1,2,3};
		
		JaegyuBubbleSort bubbleSort = new JaegyuBubbleSort();
		assertArrayEquals(result, bubbleSort.improvedSort(input));
	}
	
	@Test
	public void testImprovedSort2() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{1,2,3};
		
		JaegyuBubbleSort bubbleSort = new JaegyuBubbleSort();
		assertArrayEquals(result, bubbleSort.improvedSort(input));
	}
	
	@Test
	public void testSwap() throws Exception {
		int[] input  = new int[]{1,2,3};
		int[] result = new int[]{2,1,3};
		
		JaegyuBubbleSort bubbleSort = new JaegyuBubbleSort();
		assertArrayEquals(result, bubbleSort.swap(input,0,1));
	}
}
