package chapter3.insertsort;

/**
 * @author WonChul Choi
 *
 */
public class WonChulInsertSort implements InsertionSort{

	@Override
	public int[] sort(int[] input) {
		int pos, temp;
		for (int i = 1; i < input.length; i++) {
			pos = i;
			temp = input[i];
			while (pos >= 1 && (input [pos-1] > input[pos])) {
				input[pos] = input[pos-1];
				pos--;
			}
			input[pos] = temp;
		}
		return input;
	}
	
}
