package chapter3.mergesort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ihseo
 */
public class ILhyunMergeSortTest {

	@Test
	public void sortTest() throws Exception {
		int[] input = new int[]{31, 3, 65, 73, 8, 11, 20, 29, 48, 15};
		int[] output = new int[]{3, 8, 11, 15, 20, 29, 31, 48, 65, 73};
		
		MergeSort mergeSort = new ILhyunMergeSort();
		int[] result = mergeSort.sort(input);
		
		for(int i = 0 ; i < input.length ; i++) {
			assertThat(result[i], is(output[i]));
		}
	}
}
