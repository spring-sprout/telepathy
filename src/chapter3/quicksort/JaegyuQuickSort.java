package chapter3.quicksort;

public class JaegyuQuickSort {

	public int[] sort(int[] input) {
		
		int p = 0;
		int r = input.length-1;
		
		this.quickSort(input,p,r);
		
		return input;
	}

	private void quickSort(int[] input, int p, int r) {
		
		if(p<r){
			int q = this.partition(input,p,r);
			quickSort(input, p, q-1);
			quickSort(input, q+1, r);
		}
	}

	private int partition(int[] input, int p, int r) {
		int x = input[r];
		int i = p-1;
		
		for(int j = p;j<=r-1;j++){
			if(input[j] <= x){
				this.swap(input, ++i, j);
			}			
		}
		
		this.swap(input, i+1, r);
		return i+1;
	}
	
	public int[] swap(int[] input, int i, int j) {
		int temp = 0;
		
		temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
		return input;
	}
}
