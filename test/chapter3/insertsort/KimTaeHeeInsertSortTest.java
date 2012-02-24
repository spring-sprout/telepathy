package chapter3.insertsort;

import org.junit.Test;
import static chapter3.AssertSortUtil.*;

import chapter3.Sort;

public class KimTaeHeeInsertSortTest {

	Sort insertSort = new KimTaeHeeInsertSort();

	@Test
	public void testSort(){
		int[] actualIntArray = {5, 4, 3, 2, 1};
		insertSort.sort( actualIntArray );
		assertSort( actualIntArray);
	}
}
