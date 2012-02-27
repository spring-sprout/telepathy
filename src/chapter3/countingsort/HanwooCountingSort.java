package chapter3.countingsort;

import chapter3.Sort;

public class HanwooCountingSort implements CountingSort {

	@Override
	public int[] sort(int[] input) {
		int max = getMaxValue(input);
		return countingSort(input, max);
	}

	private int[] countingSort(int[] input, int max) {
		int[] sortInput = new int[input.length];
		int[] counters = new int[max + 1];

//		for (int i = 0; i < counters.length; i++) {
//			counters[i] = 0;
//		}
		
		for (int i : input) {
			counters[i]++;
		}

		for (int i = 1; i < counters.length; i++) {
			counters[i] = counters[i] + counters[i - 1]; 
		}

		for (int i = input.length - 1; i >= 0; i--) {
			sortInput[counters[input[i]] - 1] = input[i];
			counters[input[i]]--;
		}

		return sortInput;
	}



	private int getMaxValue(int[] input) {
		int max = 0;
		
		for (int i : input) {
			if(i > max)
				max = i;
		}
		
		return max;
	}

}
