package chapter3.bubblesort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ihseo
 */
public class ILhyunBubbleSortTest {

	@Test
	public void sortTest() throws Exception {
		int[] input = new int[]{29, 10, 14, 37, 13};
		int[] output = new int[]{10, 13, 14, 29, 37};
		
		BubbleSort bubbleSort = new ILhyunBubbleSort();
		int[] result = bubbleSort.sort(input);
		
		for(int i = 0 ; i < input.length ; i++) {
			assertThat(result[i], is(output[i]));
		}
	}
}
