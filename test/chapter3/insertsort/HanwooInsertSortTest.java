package chapter3.insertsort;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class HanwooInsertSortTest {

	int[] input;
	int[] output;

	@Before
	public void setUp() throws Exception {
		input = new int[]{3, 7, 8, 2, 4, 1, 6, 3, 10};
		output = new int[]{1, 2, 3, 3, 4, 6, 7, 8, 10};
	}

	@Test
	public void test() {
		HanwooInsertSort insertSort = new HanwooInsertSort();
//		assertReflectionEquals("배열 비교전 데이터 일치 여부", input, output, ReflectionComparatorMode.LENIENT_ORDER);
		int[] sort = insertSort.sort(input);

//		assertReflectionEquals("배열 비교", sort, output);
	}
}
