package chapter3.selectionsort;

import chapter3.SortUtil;


public class KimTaeHeeSelectionSort implements SelectionSort{

	@Override
	public int[] sort(int[] input) {
		SortUtil.valid(input);
		int lastIndex = input.length - 1;
		while( lastIndex > 0 ){
			
			int maxValueIndex = getMaxValueIndex(input, lastIndex);			
			
			// swap
			SortUtil.swap(input, maxValueIndex, lastIndex);
			
			lastIndex--;
		}
		return input;
	}
	
	private int getMaxValueIndex(int input[], int lastIndex){
		int maxValue = input[0];
		int maxValueIndex = 0;
		
		for( int i = 1 ; i <= lastIndex; i++){
			if( maxValue <= input[i]){
				maxValue = input[i];
				maxValueIndex = i;
			}
		}
		return maxValueIndex;
	}
}
