package chapter3.selectionsort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class KeesunSelectionSortTest {

	@Test
	public void sort(){
//		int[] input = new int[]{3, 2, 1, 5, 10, 2};
//		int[] output = new int[]{1, 2, 2, 3, 5, 10};
		int[] input = {73,31,48,8,3,65,20,29,11,15};
		int[] output = {3,8,11,15,20,29,31,48,65,73};

		SelectionSort selectionSort = new KeesunSelectionSort();
		int[] result = selectionSort.sort(input);

		for(int i = 0 ; i < input.length ; i++) {
			assertThat(result[i], is(output[i]));
		}
	}


}
