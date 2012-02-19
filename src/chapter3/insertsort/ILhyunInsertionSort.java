package chapter3.insertsort;

/**
 * @author ihseo
 */
public class ILhyunInsertionSort implements InsertionSort {

	@Override
	public int[] sort(int[] input) {
		int size = input.length;
		
		// insertion sort
		for(int i = 1; i < size; i++){
			int index = i-1;
			int copy = input[i];
			
			while(index >= 0 && copy < input[index] ){
				// shift
				input[index+1] = input[index];
				index--;
			}
			
			input[index+1] = copy;
		}

		return input;
	}

}
