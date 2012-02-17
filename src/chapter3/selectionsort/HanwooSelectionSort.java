package chapter3.selectionsort;

public class HanwooSelectionSort implements SelectionSort {

	@Override
	public int[] sort(int[] input) {

		int maxValue;
		int lastKey;
		int lastValue;
		int maxKey;

		for(int i = input.length-1; i > 0; i--) {
			maxKey = i;
			lastKey = i;
			lastValue = input[i];

			for(int j = 0; j < i; j++) {
				if(input[j] > input[maxKey]) {
					maxKey = j;
				}
			}

			maxValue = input[maxKey];
			input[maxKey] = lastValue;
			input[lastKey] = maxValue;
		}
		return input;
	}
}
