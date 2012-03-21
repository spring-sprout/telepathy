package chapter3.bubblesort;

import chapter3.SortUtil;

public class KimTaeHeeBubbleSort implements BubbleSort{

	@Override
	public int[] sort(int[] input) {
		SortUtil.valid(input);
		int lastIndex = input.length - 1;
		for(; lastIndex > 0 ; lastIndex--){
			boolean isSorted = true;
			for(int i = 0; i < lastIndex; i++){
				if( input[i] > input[i+1]){
					SortUtil.swap(input, i, i + 1);
					isSorted = false;
				}
			}
			if( isSorted ){
				return input;
			}			
		}
		return input;
	}
	
}
