package chapter3.bubblesort;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class ChihoonBubbleSortTest {

	@Test
	public void bubbleSortTest() throws Exception {
		int[] input = {3,31,48,73,8,11,20,29,65,15};
		int[] output = {3,8,11,15,20,29,31,48,65,73};
		
		BubbleSort bubble = new ChihoonBubbleSort();
		int[] result = bubble.sort(input);
		
		for(int i=0; i<output.length; i++){
			assertThat(output[i], is(result[i]));
		}
	}
}
