package chapter3.selectionsort;

public class SeunghoSelectionSort implements SelectionSort {

	@Override
	public int[] sort(int[] input) {
		int lastIndex = -1;
		int largestNumberIndex = -1;
		for (int i = 0; i < input.length; i++) {
			lastIndex = input.length - i - 1;
			
			for (int j = 0; j < lastIndex; j++) {
				if (input[j] > ((largestNumberIndex >= 0) ? input[largestNumberIndex] : 0)) {
					if (input[j] > input[lastIndex]) {
						largestNumberIndex = j;
					}
				}
			}
			
			if (largestNumberIndex != -1) {
				int temp = input[lastIndex];
				input[lastIndex] = input[largestNumberIndex];
				input[largestNumberIndex] = temp;
			}
			largestNumberIndex = -1;
		}
		
		return input;
	}
}
