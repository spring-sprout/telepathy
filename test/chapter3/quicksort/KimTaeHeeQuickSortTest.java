package chapter3.quicksort;

import org.junit.Test;
import static chapter3.AssertSortUtil.*;

import chapter3.Sort;

public class KimTaeHeeQuickSortTest {
	Sort quickSort = new KimTaeHeeQuickSort();
	
	@Test
	public void testSort(){
		int[] actualIntArray = {6, 5, 4, 3, 2, 1};
		quickSort.sort(actualIntArray);
		assertSort(actualIntArray);
	}
}
