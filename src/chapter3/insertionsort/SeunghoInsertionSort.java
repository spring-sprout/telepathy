package chapter3.insertionsort;

/**
 * 
 * @author Seungho Seo
 * 
 */
public class SeunghoInsertionSort implements InsertionSort {

	@Override
	public int[] sort(int[] input) {
		for (int last = 1; last < input.length; last++) {
			int loc = last - 1;
			int insertValue = input[last];

			while (1 <= loc && insertValue < input[loc]) {
				input[loc + 1] = input[loc];
				loc--;
			}

			input[loc + 1] = insertValue;
		}

		return input;
	}

}
