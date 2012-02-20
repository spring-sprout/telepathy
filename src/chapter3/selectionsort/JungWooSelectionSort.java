package chapter3.selectionsort;

import chapter3.Sort;

public class JungWooSelectionSort implements Sort {
    @Override
    public void sort(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            int minIndex = i;
            int min = inputs[i];

            for (int j = minIndex + 1; j < inputs.length; j++) {
                if (min > inputs[j]) {
                    min = inputs[j];
                    minIndex = j;
                }
            }

            inputs[minIndex] = inputs[i];
            inputs[i] = min;

        }
    }
}
