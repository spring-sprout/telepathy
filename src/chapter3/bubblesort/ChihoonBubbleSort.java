package chapter3.bubblesort;

/**
 * 
 * @author kimddochi
 *
 */
public class ChihoonBubbleSort implements BubbleSort {

	@Override
	public int[] sort(int[] input) {
		int len = input.length-1;
		for(int i = len; i > 0; i--){
			int swap = 0;
			for(int j=1; j<=i; j++){
				if(input[j-1] > input[j]){
					swap = input[j];
					input[j] = input[j-1];
					input[j-1] = swap;
				}
			}
		}
		return input;
	}

}