package chapter3.bubblesort;

import chapter3.Sort;

/**
 * @author miracle
 */
public class JungWooBubbleSort implements Sort {
    @Override
    public void sort(int[] input) {
        for (int i=0; i<input.length; i++) {
            int limitJ = input.length - i - 1;
            for (int j=0; j<limitJ; j++) {
                if (input[j] > input[j+1]) {
                    swap(input, j, j+1);
                }
            }
        }
    }

    private void swap(int[] array, int fristIndex, int secondIndex) {
        int temp = array[fristIndex];
        array[fristIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
