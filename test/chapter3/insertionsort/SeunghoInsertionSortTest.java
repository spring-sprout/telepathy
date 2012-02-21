package chapter3.insertionsort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SeunghoInsertionSortTest {
	@Test
	public void insertSortTest() throws Exception {
		int[] input = {3,31,43,78,8,11,20,29,65,15};
		int[] output = {3,8,11,15,20,29,31,43,65,78};
		
		InsertionSort insert = new SeunghoInsertionSort();
		int[] result = insert.sort(input);
		
		assertArrayEquals(result, output);

	}
}
