package chapter3.countingsort;

import chapter3.Sort;

public class DaewonCountingSort implements Sort {

	@Override
	public void sort(int[] input) {
		int maxValue = getMaxValue(input);
		countingSort(input, maxValue);
	}

	public void countingSort(int[] input, int maxValue) {
		int[] sortedArr = new int[input.length];

		int[] counters = new int[maxValue + 1];

		for (int i = 0; i < counters.length; i++) {
			counters[i] = 0;
		}

		for (int i = 0; i < input.length; i++) {
			counters[input[i]]++;
//			System.out.printf("Value:%d, Counter:%d\n", input[i], counters[input[i]]);
		}

		for (int i = 1; i < counters.length; i++) {
			counters[i] = counters[i] + counters[i - 1];
//			System.out.printf("Value:%d, Counter:%d\n", i, counters[i]);
		}

		for (int i = 0; i < input.length; i++) {
			sortedArr[counters[input[i]] - 1] = input[i];
			counters[input[i]]--;
		}

		for (int i = 0; i < sortedArr.length; i++) {
			input[i] = sortedArr[i];
		}
	}

	private int getMaxValue(int[] input) {
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max) {
				max = input[i];
			}
		}
		return max;
	}

}
