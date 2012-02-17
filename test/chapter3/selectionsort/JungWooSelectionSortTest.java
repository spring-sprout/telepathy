package chapter3.selectionsort;

import chapter3.BaseSortTest;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class JungWooSelectionSortTest extends BaseSortTest {

    @Test
    public void testSort_무작위_정렬된_배열() throws Exception {
        // Given
        JungWooSelectionSort sort = new JungWooSelectionSort();

        // When
        sort.sort(정렬되지않은_배열);

        // Then
        assertArrayEquals(정렬되지않은_배열, 정렬_결과);
    }

    @Test
    public void testSort_역정렬된_배열() throws Exception {
        // Given
        JungWooSelectionSort sort = new JungWooSelectionSort();

        // When
        sort.sort(역정렬된_배열);

        // Then
        assertArrayEquals(역정렬된_배열, 정렬_결과);
    }

    @Test
    public void testSort_정렬된_배열() throws Exception {
        // Given
        JungWooSelectionSort sort = new JungWooSelectionSort();

        // When
        sort.sort(정렬된_배열);

        // Then
        assertArrayEquals(정렬된_배열, 정렬_결과);
    }
}
