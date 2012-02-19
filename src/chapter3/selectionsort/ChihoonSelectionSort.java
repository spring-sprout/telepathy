package chapter3.selectionsort;

/**
 * 
 * @author kimddochi
 *
 */
public class ChihoonSelectionSort implements SelectionSort {

	@Override
	public int[] sort(int[] input) {
		int len = input.length - 1;
		for(int i=len; i > 0; i--){
			int max = input[i];
			int maxIndex = i;
			for(int j=0; j<i; j++){
				if(max < input[j]){
					max = input[j];
					maxIndex = j;
				}
			}
			input[maxIndex] = input[i];
			input[i] = max;
		}
		return input;
	}

		
}
