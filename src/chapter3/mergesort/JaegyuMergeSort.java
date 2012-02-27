package chapter3.mergesort;

public class JaegyuMergeSort {

	public int[] sort(int[] input) {
		int p = 0;
		int r=input.length-1;
		this.mergeSort(input, p, r);
		return input;
	}
	
	private void mergeSort(int[] input,int p,int r){
		int q = (p+r)/2;
		
		if(p<r){
			this.mergeSort(input,p,q);
			this.mergeSort(input,q+1,r);
			this.merge(input,p,q,r);
		}
	}

	private void merge(int[] input, int p, int q, int r) {
		int i=p;
		int j=q+1;
		int t=0;
		
		int[] tmp = new int[input.length];
		
		while(i<=q && j<=r){
			if(input[i] <= input[j]){
				tmp[t++] = input[i++];
			}else{
				tmp[t++] = input[j++];
			}
		}
		
		while(i<=q){
			tmp[t++] = input[i++];
		}
		while(j<=r){
			tmp[t++] = input[j++];
		}
		
		i=p;
		t=0;
		
		while(i<=r){
			input[i++] = tmp[t++];
		}
	}

}
