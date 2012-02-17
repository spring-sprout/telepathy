package chapter3.bubblesort;

import chapter3.BaseSortTest;
import chapter3.Sort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author miracle
 */
public class JungWooBubbleSortTest extends BaseSortTest{
    @Test
    public void testSort_무작위_정렬된_배열() throws Exception {
        // Given
        Sort sort = new JungWooBubbleSort();

        // When
        sort.sort(정렬되지않은_배열);

        // Then
        assertArrayEquals(정렬되지않은_배열, 정렬_결과);
    }

    @Test
    public void testSort_역정렬된_배열() throws Exception {
        // Given
        Sort sort = new JungWooBubbleSort();

        // When
        sort.sort(역정렬된_배열);

        // Then
        assertArrayEquals(역정렬된_배열, 정렬_결과);
    }

    @Test
    public void testSort_정렬된_배열() throws Exception {
        // Given
        Sort sort = new JungWooBubbleSort();

        // When
        sort.sort(정렬된_배열);

        // Then
        assertArrayEquals(정렬된_배열, 정렬_결과);
    }
}
