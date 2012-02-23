package chapter3.bubblesort;

import chapter3.Sort;

public class DaewonBubbleSort implements Sort {

	@Override
	public void sort(int[] input) {
		int lastIdx = (input.length-1);
		for (; lastIdx > 0; lastIdx--) {
			boolean isSorted = true;

			for (int i = 0; i < lastIdx; i++) {
				if (input[i] > input[i + 1]) {
					swap(input, i, i + 1);
					isSorted = false;
				}
			}

			if(isSorted) return;
		}
	}

	private void swap(int[] input, int idx1, int idx2) {
		int temp = input[idx2];
		input[idx2] = input[idx1];
		input[idx1] = temp;
	}

}
