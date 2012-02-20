package chapter3.quicksort;

public class HanwooQuickSort implements QuickSort {

	@Override
	public int[] sort(int[] input) {
		quickSort(input, 0, input.length-1);
		return input;
	}
	
	private void quickSort(int[] input, int firstKey, int secondKey) {
		if(firstKey < secondKey) {
			int lastDataKey = partition(input, firstKey, secondKey);
			quickSort(input, firstKey, lastDataKey-1);
			quickSort(input, lastDataKey+1, secondKey);
//			System.out.format("firstKey : %d, secondKey : %d, center : %d \n", firstKey, secondKey, lastDataKey);
//			for (int i : input) {
//				System.out.print(i+", ");
//			}
//			System.out.println("");
		}
	}

	private int partition(int[] input, int firstKey, int secondKey) {
		int lastData = input[secondKey];
		int sortKey = firstKey;
		for (int i = firstKey; i < secondKey; i++) {
			if(input[i] <= lastData) {
				changeData(input, sortKey, i);
				sortKey++;
			}
		}

		changeData(input, sortKey, secondKey);

		return sortKey;
	}
	
	private void changeData(int[] input, int key1, int key2) {
		int tmpData = input[key1];
		input[key1] = input[key2];
		input[key2] = tmpData;
	}

}
