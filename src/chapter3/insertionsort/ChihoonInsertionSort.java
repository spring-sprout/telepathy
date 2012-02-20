package chapter3.insertionsort;

public class ChihoonInsertionSort implements InsertionSort {

	@Override
	public int[] sort(int[] input) {
		for(int i = 1 ; i < input.length; i++){
			int index = i;
			int swap = input[index];
			while( (index > 0) && (input[index - 1] > input[index]) ){
				input[index] = input[index - 1];
				input[index - 1] = swap;
				index--;
			}
			input[index] = swap;
		}
		return input;
	}
}