package chapter3.selectionsort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SeunghoSelectionSortTest {
	@Test
	public void selectionSort() {
		SelectionSort selectionSort = new SeunghoSelectionSort();
		int[] result = selectionSort.sort(new int[]{100, 4,3,2,1});
		assertArrayEquals(result, new int[]{1, 2, 3, 4, 100});
	}
}
