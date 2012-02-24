package chapter3.bubblesort;

/**
 * @author WonChul Choi
 *
 */
public class WonChulBubbleSort implements BubbleSort{

	@Override
	public int[] sort(int[] input) {
		int temp;
		for (int i = 0; i < input.length; i++) {
			temp = input[i];	
			for (int j = 0; j < input.length; j++) {
				if(temp > input[j]){
					input[i] = input[j];
					input[j] = temp; 
				}
			}
		}
		return input;
	}
}
