package chapter3.bubblesort;

import static chapter3.AssertSortUtil.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class KimTaeHeeBubbleSortTest {
	BubbleSort bubbleSort = new KimTaeHeeBubbleSort();
	
	@Test
	public void testSort(){
		assertSort( bubbleSort.sort(new int[]{3, 1, 2, -5, 8}) );
		assertSort( bubbleSort.sort(new int[]{1, 1, 1, 1, 1, 1}) );
		assertSort( bubbleSort.sort(new int[]{3, 1}) );
		assertSort( bubbleSort.sort(new int[]{3}) );
		
		try{
			bubbleSort.sort(new int[]{});
			fail();
		}catch(IllegalArgumentException ex){
			
		}
	}
}
