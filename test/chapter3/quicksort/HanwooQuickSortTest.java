package chapter3.quicksort;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class HanwooQuickSortTest {

	int[] input;
	int[] output;

	@Before
	public void setUp() throws Exception {
		input = new int[]{3, 7, 8, 2, 4, 1, 6, 3, 10, 5, 8};
		output = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 10};
	}

	@Test
	public void test() {
		HanwooQuickSort quickSort = new HanwooQuickSort();
		assertReflectionEquals("배열 비교전 데이터 일치 여부", input, output, ReflectionComparatorMode.LENIENT_ORDER);
		int[] sort = quickSort.sort(input);

		assertReflectionEquals("배열 비교", sort, output);
	}
}
