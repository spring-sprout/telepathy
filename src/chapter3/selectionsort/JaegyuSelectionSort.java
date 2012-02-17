package chapter3.selectionsort;

/**
 * @author JaeGyu
 */
public class JaegyuSelectionSort {

	public int[] sort(int[] input) {
		int last = input.length-1;
		
		for(int i=last;i>0;i--){
			int maxIndex = this.returnMaxIndex(input, i);
			swap(input, maxIndex, i);
		}
		
		return input;
	}

	public int returnMaxIndex(int[] input, int last) {
		int maxIndex = 0;
		
		for(int i=1;i<=last;i++){
			if(input[i]>input[maxIndex]) maxIndex = i;
		}
		
		return maxIndex;
	}

	public int[] swap(int[] input, int i, int j) {
		int temp = 0;
		
		temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
		return input;
	}

}
