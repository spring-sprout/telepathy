package chapter3.bubblesort;

/**
 * @author JaeGyu
 */
public class JaegyuBubbleSort {

	public int[] sort(int[] input) {
		
		for(int i=input.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(input[j]>input[j+1]){
					swap(input,j,j+1);
				}
			}
		}
		
		return input;
	}
	
	public int[] improvedSort(int[] input) {
		boolean sorted = true;
		
		for(int i=input.length-1;i>0;i--){
			sorted = true;
			for(int j=0;j<i;j++){
				if(input[j] > input[j+1]){
					swap(input, j, j+1);
					sorted = false;
				}
			}
			if(sorted == true) return input;
		}
		return input;
	}
	
	public int[] swap(int[] input, int i, int j) {
		int temp = 0;
		
		temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
		return input;
	}
	
}
