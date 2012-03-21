package chapter3.quicksort;

/**
 * @author WonChul Choi
 *
 */
public class WonChulQuickSort implements QuickSort {

	@Override
	public int[] sort(int[] input) {
		quickSort(input, 0, input.length-1);
		return null;
	}
	
	private void quickSort(int[] input, int start, int end){
		if(start < end){
			int temp = partition(input, start, end);
			quickSort(input, start, temp-1);
			quickSort(input, temp+1, end);
		}
	}

	private int partition(int[] input, int start, int end) {
		int value = input[end];
		int pos = start;
		int temp;
		for (int i = 0; i < input.length-1; i++) {
			if(input[i] <= value){
				temp = input[pos];
				input[pos] = input[i];
				input[i] = temp;
				pos++;
			}
		}
		return pos;
	}
}


