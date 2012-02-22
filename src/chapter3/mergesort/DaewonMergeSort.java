package chapter3.mergesort;

import chapter3.Sort;

public class DaewonMergeSort implements Sort {

	@Override
	public void sort(int[] input) {
		mergeSort(input, 0, input.length - 1);
	}

	private void mergeSort(int[] input, int start, int end) {
		if(start >= end) return;

		int middle = (start + end) / 2;
		mergeSort(input, start, middle);
		mergeSort(input, middle + 1, end);
		merge(input, start, middle, end);
	}

	private void merge(int[] input, int start, int middle, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = middle + 1;
		int tempIdx = 0;

		while (i <= middle && j <= end) {
			if (input[i] <= input[j]) {
				temp[tempIdx++] = input[i++];
			} else {
				temp[tempIdx++] = input[j++];
			}
		}

		while (i <= middle) {
			temp[tempIdx++] = input[i++];
		}
		while (j <= end) {
			temp[tempIdx++] = input[j++];
		}

		tempIdx = 0;
		i = start;
		for (; i <= end; i++) {
			input[i] = temp[tempIdx++];
		}
	}
}
