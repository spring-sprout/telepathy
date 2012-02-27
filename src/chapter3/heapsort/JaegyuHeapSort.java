package chapter3.heapsort;

public class JaegyuHeapSort {

	public int[] sort(int[] a) {
		
		int n = a.length-1;
		
		buildHeap(a,n);
		
		for(int i=n;i>0;i--){
			swap(a,0,i);
			heapify(a,0,i-1);
		}
		
		return a;
	}
	
	private void buildHeap(int[] a, int n) {
		
		for(int i = n/2;i>=0;i--){
			heapify(a, i, n);
		}
	}
	
	private void heapify(int[] a, int k, int n) {
		int left = 2*k+1;
		int right = 2*k+2;
		int smaller = 0;
		
		if(right<=n){
			if(a[left]>a[right]){
				smaller = left;
			}else{
				smaller = right;
			}
		}else if(left<=n){
			smaller = left;
		}else{
			return ;
		}
		
		if(a[smaller]>a[k]){
			swap(a,k,smaller);
			heapify(a, smaller, n);
		}
		
	}

	public int[] swap(int[] input, int i, int j) {
		int temp = 0;
		
		temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
		return input;
	}
	

}
