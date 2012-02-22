package chapter3.mergesort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SeunghoMergeSortTest{
	@Test
	public void bubbleSortTest() {
		int[] input = { 100, 15, 33, 39, 1, 2, 3, 4 };
		int[] output = { 1, 2, 3, 4, 15, 33, 39, 100 };

		MergeSort mergeSort = new SeunghoMergeSort();
		int[] result = mergeSort.sort(input);
		
		assertArrayEquals(result, output);
	}
}
