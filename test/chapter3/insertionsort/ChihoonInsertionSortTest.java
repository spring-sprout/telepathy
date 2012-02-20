package chapter3.insertionsort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import chapter3.insertionsort.ChihoonInsertionSort;
import chapter3.insertionsort.InsertionSort;

public class ChihoonInsertionSortTest {

	@Test
	public void insertSortTest() throws Exception {
		int[] input = {3,31,43,78,8,11,20,29,65,15};
		int[] output = {3,8,11,15,20,29,31,43,65,78};
		
		InsertionSort insert = new ChihoonInsertionSort();
		int[] result = insert.sort(input);
		
		for(int i=0; i<output.length; i++){
			assertThat(output[i], is(result[i]));
		}
	}
	
}
