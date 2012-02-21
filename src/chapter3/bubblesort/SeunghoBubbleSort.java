package chapter3.bubblesort;

/**
 * 
 * @author Seungho Seo
 * 
 */
public class SeunghoBubbleSort implements BubbleSort {

	@Override
	public int[] sort(int[] input) {
		for (int last = input.length; last > 1; last--) {
			for (int i = 0; i < last - 1; i++) {
				if (input[i] > input[i + 1]) {
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
				}
			}
		}
		return input;
	}

}
