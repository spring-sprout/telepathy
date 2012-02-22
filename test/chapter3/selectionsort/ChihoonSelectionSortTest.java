package chapter3.selectionsort;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class ChihoonSelectionSortTest {

	@Test
	public void sortTest() throws Exception {
		int[] input = {8,31,48,73,3,65,20,29,11,15};
		int[] output = {3,8,11,15,20,29,31,48,65,73};
		
		SelectionSort selection = new ChihoonSelectionSort();
		int[] result = selection.sort(input);
		
		for(int i=0; i<input.length; i++){
			assertThat(output[i], is(result[i]));
		}
	}
}
