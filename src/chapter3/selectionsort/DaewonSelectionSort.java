package chapter3.selectionsort;

import chapter3.Sort;

public class DaewonSelectionSort implements Sort {

	@Override
	public void sort(int[] input) {
		int lastIdx = input.length - 1;
		for (; lastIdx > 2; lastIdx--) {
			int idxOfMax = indexOfMaxValue(input, lastIdx);
			swap(input, lastIdx, idxOfMax);
		}
	}

	private void swap(int[] input, int lastIdx, int idxOfMax) {
		int largestVal = input[idxOfMax];
		input[idxOfMax] = input[lastIdx];
		input[lastIdx] = largestVal;
	}

	private int indexOfMaxValue(int[] input, int lastIdx) {
		int idxOfMax = 0;
		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; i <= lastIdx; i++) {
			if (input[i] > maxValue) {
				maxValue = input[i];
				idxOfMax = i;
			}
		}

		return idxOfMax;
	}

}
