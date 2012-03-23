package chapter3.heapsort;

import org.apache.commons.lang.ArrayUtils;

import chapter3.Sort;

public class HanwooHeapSort implements Sort {

	@Override
	public void sort(int[] input) {
		heapSort(input, input.length-1);
		ArrayUtils.reverse(input);
	}

	private void heapSort(int[] input, int lastKey) {
		buildHeap(input, lastKey);
		for (int i = lastKey; i > 0; i--) {
			changeData(input, 0, i);
			heapify(input, 0, i-1);
		}
	}

	private void buildHeap(int[] input, int lastKey) {
		for (int i = lastKey / 2; i >= 0; i--) {
			heapify(input, i, lastKey);
		}
		for (int i : input) {
			System.out.print(i + ", ");
		}
	}

	private void heapify(int[] input, int centerKey, int lastKey) {
		int left = 2 * centerKey;
		int right = 2 * centerKey + 1;
		int smaller;

		if(right <= lastKey) {
			if(input[left] < input[right])
				smaller = left;
			else
				smaller = right;
		} else if(left <= lastKey) {
				smaller = left;
		} else {
			return;
		}

		if(input[smaller] < input[centerKey]) {
			changeData(input, smaller, centerKey);
			heapify(input, smaller, lastKey);
		}
	}
	
	private void changeData(int[] input, int key1, int key2) {
		int tmpData = input[key1];
		input[key1] = input[key2];
		input[key2] = tmpData;
	}

}
