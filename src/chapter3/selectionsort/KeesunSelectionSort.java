package chapter3.selectionsort;

/**
 * @author Keesun Baik
 */
public class KeesunSelectionSort implements SelectionSort{

	@Override
	public int[] sort(int[] input) {
		for(int i = input.length ; i > 1 ; i--) {
			int maxIndex = 0;
			int max = input[maxIndex];
			for (int j = 0 ; j < i ; j++) {
				if(input[j] > max) {
					max = input[j];
					maxIndex = j;
				}
			}
			int swapIndex = i-1;
			int swap = input[swapIndex];
			input[swapIndex] = max;
			input[maxIndex] = swap;
		}
		return input;
	}
}
