package chapter3.heapsort;

import chapter3.Sort;

public class DaewonHeapSort implements Sort {

	@Override
	public void sort(int[] input) {
		int lastIdx = input.length - 1;
		buildHeap(input, lastIdx);

		for (int i = lastIdx; i > 0; i--) {
			swap(input, 0, i);
			heapify(input, 0, i - 1);
		}

		reverse(input);
	}

	private void buildHeap(int[] input, int lastIdx) {
		for (int i = lastIdx / 2; i >= 0; i--) {
			heapify(input, i, lastIdx);
		}
	}

	private void heapify(int[] input, int rootIdx, int lastIdx) {
		int left = 2 * rootIdx;
		int right = left + 1;

		int smaller = 0;
		if (right <= lastIdx) {
			if (input[left] < input[right]) {
				smaller = left;
			} else {
				smaller = right;
			}

		} else if (left <= lastIdx) {
			smaller = left;

		} else {
			return;
		}

		if(input[smaller] < input[rootIdx]) {
			swap(input, smaller, rootIdx);
			heapify(input, smaller, lastIdx);
		}
	}

	private void reverse(int[] input) {
		int[] temp = new int[input.length];

		int lastIdx = input.length - 1;
		for (int i = 0; i < input.length; i++) {
			temp[i] = input[lastIdx - i];
		}

		for (int i = 0; i < input.length; i++) {
			input[i] = temp[i];
		}
	}

	private void swap(int[] input, int idx1, int idx2) {
		int temp = input[idx2];
		input[idx2] = input[idx1];
		input[idx1] = temp;
	}

}
