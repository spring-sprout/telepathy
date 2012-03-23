package chapter3.selectionsort;

/**
 * @author maxmir
 *
 */
public class JongheonSelectionSort implements SelectionSort {

	public int[] sort(int[] input) {
		for (int last = input.length - 1; last >= 1; last--) {
			int largest = theLargest(input, last);
			
			int temp = input[largest];
			input[largest] = input[last];
			input[last] = temp;
		} // for last
		
		return input;
	} // sort()
	
	public int theLargest(int[] input, int last) {
		int largest = 0;
		
		for (int i = 1; i <= last; i++) {
			if (input[i] > input[largest])
				largest = i;
		} // for i
		
		return largest;
	} // theLargest()
	
}
