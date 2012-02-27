package chapter3.heapsort;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class HanwooHeapSortTest {

	int[] input;
	int[] output;

	@Before
	public void setUp() throws Exception {
		input = new int[]{3, 7, 8, 2, 4, 1, 6, 3, 10};
		output = new int[]{1, 2, 3, 3, 4, 6, 7, 8, 10};
	}

	@Test
	public void test() {
		HanwooHeapSort heapSort = new HanwooHeapSort();
		assertReflectionEquals("배열 비교전 데이터 일치 여부", input, output, ReflectionComparatorMode.LENIENT_ORDER);
		heapSort.sort(input);

		assertReflectionEquals("배열 비교", input, output);
	}

}
