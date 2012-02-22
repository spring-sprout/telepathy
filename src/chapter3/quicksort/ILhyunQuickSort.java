package chapter3.quicksort;

/**
 * @author ihseo
 */
public class ILhyunQuickSort implements QuickSort {

	@Override
	public int[] sort(int[] input) {
		quickSort(input, 0, input.length-1);
		return input;
	}

	private void quickSort(int[] input, int startIndex, int lastIndex){
		if(startIndex < lastIndex){
			int partitionIndex = partition(input, startIndex, lastIndex);
			quickSort(input, startIndex, partitionIndex-1);
			quickSort(input, partitionIndex+1, lastIndex);
		}
	}

	private int partition(int[] input, int startIndex, int lastIndex) {
		int key = input[lastIndex];
		int tempIndex = startIndex;
		
		for(int loop = startIndex; loop < lastIndex; loop++){
			if(input[loop] <= key){
				swap(input, tempIndex++, loop);
			}
		}
		
		swap(input, tempIndex, lastIndex);

		return tempIndex;
	}
	
	private void swap(int[] input, int idx1, int idx2){
		int temp = input[idx1];
		input[idx1] = input[idx2];
		input[idx2] = temp;
	}
}
