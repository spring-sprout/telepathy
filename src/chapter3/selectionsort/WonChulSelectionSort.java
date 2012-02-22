package chapter3.selectionsort;

/**
 * @author WonChul Choi
 *
 */
public class WonChulSelectionSort implements SelectionSort {
	
	@Override
	public int[] sort(int[] input) {
		int temp;
		
		for(int i = 0 ; i < input.length; i++){
			temp = input[i];
			for(int j = 0; j < input.length; j++) {
				if(temp < input[j])
					temp = input[j];
			}
			input[(input.length-1)] = temp; 
		}
		return input;
		
	}

}
