package chapter3.bubblesort;

/**
 * @author KJHn
 *
 */
public class JongheonBubbleSort implements BubbleSort {
	
	@Override
	public int[] sort(int[] input) {
		for (int lastNum = input.length-1; lastNum > 0; lastNum--) {
			for (int curNum = 0; curNum < lastNum; curNum++) {
				if (input[curNum] > input[curNum+1]) {
					int temp = input[curNum];
					input[curNum] = input[curNum+1];
					input[curNum+1] = temp;
				}
			}
		}
		
		return input;
	}
}