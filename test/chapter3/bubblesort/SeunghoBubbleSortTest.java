package chapter3.bubblesort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SeunghoBubbleSortTest {
	@Test
	public void bubbleSortTest() {
		int[] input = { 100, 15, 33, 39, 1, 2, 3, 4 };
		int[] output = { 1, 2, 3, 4, 15, 33, 39, 100 };

		BubbleSort bubble = new SeunghoBubbleSort();
		int[] result = bubble.sort(input);

		assertArrayEquals(result, output);
	}
}
