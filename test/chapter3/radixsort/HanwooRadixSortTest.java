package chapter3.radixsort;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class HanwooRadixSortTest {

	int[] input;
	int[] output;

	@Before
	public void setUp() throws Exception {
		input = new int[]{323, 7234, 82, 2, 4234, 12344, 653, 3345, 10345, 5345, 832};
		output = new int[]{2, 82, 323, 653, 832, 3345, 4234, 5345, 7234, 10345, 12344};
	}

	@Test
	public void test() {

		HanwooRadixSort radixSort = new HanwooRadixSort();
		assertReflectionEquals("배열 비교전 데이터 일치 여부", input, output, ReflectionComparatorMode.LENIENT_ORDER);
		radixSort.sort(input);

		assertReflectionEquals("배열 비교", input, output);
	}
}
