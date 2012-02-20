package chapter3.quicksort;

import chapter3.Sort;

public class DaewonQuickSort implements Sort {

	@Override
	public void sort(int[] input) {
		quickSort(input, 0, input.length - 1);
	}

	private void quickSort(int[] input, int firstIdx, int lastIdx) {
		if (firstIdx < lastIdx) {
			int partitionIdx = partition(input, firstIdx, lastIdx);
			quickSort(input, firstIdx, partitionIdx - 1);
			quickSort(input, partitionIdx + 1, lastIdx);
		}
	}

	private int partition(int[] input, int firstIdx, int lastIdx) {
		int partitionIdx = firstIdx;
		int partitionVal = input[lastIdx];

		for (int j = firstIdx; j < lastIdx; j++) {
			if (input[j] <= partitionVal)
				swap(input, partitionIdx++, j);
		}

		swap(input, partitionIdx, lastIdx);

		return partitionIdx;
	}

	private void swap(int[] input, int idx1, int idx2) {
		int temp = input[idx2];
		input[idx2] = input[idx1];
		input[idx1] = temp;
	}

}
