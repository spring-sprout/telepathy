package chapter3.selectionsort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ihseo
 */
public class ILhyunSelectionSortTest {

	@Test
	public void sortTest() throws Exception {
		int[] input = new int[]{8, 31, 48, 73, 3, 65, 20, 29, 11, 15};
		int[] output = new int[]{3, 8, 11, 15, 20, 29, 31, 48, 65, 73};
		
		SelectionSort selectionSort = new ILhyunSelectionSort();
		int[] result = selectionSort.sort(input);

		for(int i = 0 ; i < input.length ; i++) {
			assertThat(result[i], is(output[i]));
		}
	}
}
