package chapter3.mergesort;

import chapter3.Sort;
import chapter3.SortUtil;

public class KimTaeHeeMergeSort implements Sort{

	@Override
	public void sort(int[] input) {
		SortUtil.valid(input);
		mergeSort(input, 0, input.length - 1);
	}

	private void mergeSort(int[] input, int firstIndex, int lastIndex){
		if( firstIndex < lastIndex ){
			int halfIndex = (firstIndex + lastIndex) / 2 ;
			mergeSort(input, firstIndex, halfIndex);
			mergeSort(input, halfIndex + 1, lastIndex);
			merge(input, firstIndex, halfIndex, lastIndex);
		}
	}
	
	private void merge(int[] input, int firstIndex, int halfIndex, int lastIndex){
		int i = 0;
		int j = halfIndex + 1;
		int t = 1;
		int[] tempInput = new int[input.length];
		while( i <= halfIndex && j <= lastIndex){
			if( input[i] <= input[j] ){
				tempInput[t++] = input[i++];
			}else{
				tempInput[t++] = input[j++];
			}
		}
		
		while( i < halfIndex ){
			tempInput[t++] = input[i++];
		}
		
		while( j <= lastIndex ){
			tempInput[t++] = input[j++];
		}
		
		i = firstIndex;
		t = 0;
		while( i < lastIndex ){
			input[i++] = tempInput[t++];
		}
	}
}
