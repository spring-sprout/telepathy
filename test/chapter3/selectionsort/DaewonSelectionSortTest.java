package chapter3.selectionsort;

import org.junit.Assert;
import org.junit.Test;

import chapter3.Sort;

public class DaewonSelectionSortTest {

	Sort sort = new DaewonSelectionSort();

	@Test
	public void 임의의배열테스트() {
		int[] arr = new int[] {5, 2, 3, 4, 1};
		int arraySize = arr.length;
		sort.sort(arr);

		Assert.assertEquals(arraySize, arr.length);
		assertSortedArray(arr);
	}

	@Test
	public void 역순배열테스트() {
		int[] arr = new int[] {5, 4, 3, 2, 1};
		sort.sort(arr);

		assertSortedArray(arr);
	}

	@Test
	public void 정렬된배열테스트() {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		sort.sort(arr);

		assertSortedArray(arr);
	}

	private void assertSortedArray(int[] arr) {
		for(int i = 0; i < (arr.length - 1); i++) {
			System.out.printf("%d ", arr[i]);
			Assert.assertTrue(arr[i] <= arr[i + 1]);
		}
		System.out.println(arr[arr.length -1]);
	}
}
