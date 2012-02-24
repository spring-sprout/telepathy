package chapter3.quicksort;

import chapter3.Sort;
import chapter3.SortUtil;

public class KimTaeHeeQuickSort implements Sort{

	@Override
	public void sort(int[] input) {
		quickSort(input, 0, input.length -1 );
	}
	
	private void quickSort(int[] input, int firstIndex, int lastIndex){
		if( firstIndex < lastIndex ){
			int divideIndex = partition(input, firstIndex, lastIndex);
			quickSort(input, firstIndex, divideIndex - 1);
			quickSort(input, divideIndex + 1, lastIndex);
		}
	}
	
	private int partition(int[] input, int firstIndex, int lastIndex){
		int criteriaValue = input[lastIndex];
		int i = firstIndex - 1;
		for( int j = firstIndex; j < lastIndex; j++ ){
			if( input[j] <= criteriaValue ){
				SortUtil.swap(input, ++i, j);
			}
		}
		SortUtil.swap(input, i + 1, lastIndex);
		return i + 1;
	}

}
