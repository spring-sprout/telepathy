package chapter3.insertionsort;

import chapter3.Sort;

public class DaewonInsertionSort implements Sort {

	@Override
	public void sort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			int idx = i;
			int insertVal = input[i];
			for (int j = i - 1; j >= 0; j--) {
				if (insertVal < input[j]) {
					swap(input, idx--, j);
				}
			}
		}
	}

	private void swap(int[] input, int idx1, int idx2) {
		int temp = input[idx2];
		input[idx2] = input[idx1];
		input[idx1] = temp;
	}

}
