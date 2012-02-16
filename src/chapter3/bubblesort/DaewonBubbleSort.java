package chapter3.bubblesort;

import chapter3.Sort;

public class DaewonBubbleSort implements Sort {

	@Override
	public void sort(int[] input) {

	}

	private void swap(int[] input, int lastIdx, int idxOfMax) {
		int largestVal = input[idxOfMax];
		input[idxOfMax] = input[lastIdx];
		input[lastIdx] = largestVal;
	}


}
