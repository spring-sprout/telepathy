package chapter3.selectionsort;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class JungWooSelectionSortTest {
    private int[] input = new int[]{3, 2, 1, 5, 10, 2};
    private final int[] output = new int[]{1, 2, 2, 3, 5, 10};

    @Test
    public void testSort() throws Exception {
        // Given
        JungWooSelectionSort sort = new JungWooSelectionSort();

        // When
        sort.sort(input);

        // Then
        assertThat(Arrays.equals(input, output), is(true));
    }
}
