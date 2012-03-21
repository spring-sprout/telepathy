package chapter3.quicksort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author ihseo
 */
public class ILhyunQuickSortTest {

	@Test
	public void sortTest() throws Exception {
		//int[] input = new int[]{29, 10, 14, 37, 13};
		//int[] output = new int[]{10, 13, 14, 29, 37};
		
		int[] input = new int[]{8, 31, 48, 73, 3, 65, 20, 29, 11, 15};
		int[] output = new int[]{3, 8, 11, 15, 20, 29, 31, 48, 65, 73};
		
		QuickSort quickSort = new ILhyunQuickSort();
		int[] result = quickSort.sort(input);
		
		for(int i = 0 ; i < input.length ; i++) {
			assertThat(result[i], is(output[i]));
		}
	}
}
