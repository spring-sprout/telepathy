package chapter3.radixsort;

import org.junit.Assert;
import org.junit.Test;

import chapter3.Sort;

public class DaewonRadixSortTest {

	Sort sort = new DaewonRadixSort();

	@Test
	public void 임의의배열테스트() {
		int[] arr = new int[] { 123, 2154, 222, 4, 283, 1560, 1061, 2150 };
		sort.sort(arr);

		printArray(arr);
		assertSortedArray(arr);
	}

	@Test
	public void 역순배열테스트() {
		int[] arr = new int[] { 1560, 2150, 1061, 222, 123, 283, 2154, 4 };
		sort.sort(arr);

		printArray(arr);
		assertSortedArray(arr);
	}

	@Test
	public void 정렬된배열테스트() {
		int[] arr = new int[] { 4, 123, 222, 283, 1061, 1560, 2150, 2150, 2154 };
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
			Assert.assertTrue(arr[i] <= arr[i + 1]);
		}
	}
}
