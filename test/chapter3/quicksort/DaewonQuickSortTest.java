package chapter3.quicksort;

import org.junit.Assert;
import org.junit.Test;

import chapter3.Sort;

public class DaewonQuickSortTest {

	Sort sort = new DaewonQuickSort();

	@Test
	public void 임의의배열테스트() {
		int[] arr = new int[] { 5, 2, 3, 4, 1 };
		sort.sort(arr);

		printArray(arr);
		assertSortedArray(arr);
	}

	@Test
	public void 역순배열테스트() {
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		sort.sort(arr);

		printArray(arr);
		assertSortedArray(arr);
	}

	@Test
	public void 정렬된배열테스트() {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		sort.sort(arr);

		printArray(arr);
		assertSortedArray(arr);
	}

	private void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println("");
	}

	private void assertSortedArray(int[] arr) {
		for (int i = 0; i < (arr.length - 1); i++) {
			Assert.assertTrue(arr[i] < arr[i + 1]);
		}
	}
}
