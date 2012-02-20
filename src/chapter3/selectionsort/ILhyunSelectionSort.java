package chapter3.selectionsort;

/**
 * @author ihseo
 */
public class ILhyunSelectionSort implements SelectionSort{

	@Override
	public int[] sort(int[] input) {
		int lastIndex = input.length-1;
		
		for(int loop = lastIndex; loop >= 1; loop--){ 
			// loop == lastIndex
			int maxIndex = maxIndex(input, loop);
			
			int temp = input[maxIndex];
			input[maxIndex] = input[loop]; 
			input[loop] = temp; // max value -> lastIndex
		}
		
		return input;
	}

	/**
	 * @param array
	 * @param lastIndex
	 * @return 최대값 인덱스
	 */
	private int maxIndex(int[] array, int lastIndex){
		int maxIndex = 0;
		for(int loop = 0; loop <= lastIndex; loop++){
			if(array[loop] > array[maxIndex]){
				maxIndex = loop;
			}
		}
		return maxIndex;
	}

}
