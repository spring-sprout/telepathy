package chapter3.bubblesort;

/**
 * @author ihseo
 */
public class ILhyunBubbleSort implements BubbleSort {

	@Override
	public int[] sort(int[] input) {
		boolean isSorted;
		int lastIndex = input.length-1;
		
		for(int loop = lastIndex; loop >= 1; loop--){
			isSorted = true;
			
			for(int i = 0; i < loop; i++){
				if(input[i] > input[i+1]){
					//swap
					int temp = input[i];
					input[i] = input[i+1];
					input[i+1] = temp;
					
					isSorted = false;
				}
			}
			if(isSorted) break;
		}
		
		return input;
	}

}
