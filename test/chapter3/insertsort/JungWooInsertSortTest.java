package chapter3.insertsort;

import chapter3.BaseSortTest;
import chapter3.Sort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author miracle
 */
public class JungWooInsertSortTest extends BaseSortTest {
    @Test
    public void testSort_무작위_정렬된_배열() throws Exception {
        // Given
        Sort sort = new JungWooInsertSort();

        // When
        sort.sort(정렬되지않은_배열);

        // Then
        assertArrayEquals(expectedSortedArray, 정렬되지않은_배열);
    }

    @Test
    public void testSort_역정렬된_배열() throws Exception {
        // Given
        Sort sort = new JungWooInsertSort();

        // When
        sort.sort(역정렬된_배열);

        // Then
        assertArrayEquals(expectedSortedArray, 역정렬된_배열);
    }

    @Test
    public void testSort_정렬된_배열() throws Exception {
        // Given
        Sort sort = new JungWooInsertSort();

        // When
        sort.sort(정렬된_배열);

        // Then
        assertArrayEquals(expectedSortedArray, 정렬된_배열);
    }
}
