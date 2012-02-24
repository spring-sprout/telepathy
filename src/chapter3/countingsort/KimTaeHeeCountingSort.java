package chapter3.countingsort;

import chapter3.Sort;
import chapter3.SortUtil;

public class KimTaeHeeCountingSort implements Sort{

	@Override
	public void sort(int[] input) {
		SortUtil.valid(input);
		int maxValue = getMaxValue(input);
		int[] counts = new int[maxValue + 1];
		for(int i = 0; i < counts.length; i++){
			counts[i] = 0;
		}
		
		for(int j = 0; j < input.length; j++){
			counts[input[j]]++;
		}
		
		for( int i = 1; i < counts.length; i++){
			counts[i] = counts[i] + counts[i-1];
		}
		
		int[] sortedInput = new int[input.length];
		for(int j = input.length - 1; j >= 0; j--){
			sortedInput[counts[input[j]] - 1] = input[j];
			counts[input[j]]--;
		}
		
		for(int i = 0; i < sortedInput.length; i++){
			input[i] = sortedInput[i];
		}
	}

	private int getMaxValue(int[] input) {
		int maxValue = Integer.MIN_VALUE;
		for(int value : input){
			if( maxValue <= value ){
				maxValue = value;
			}
		}
		return maxValue;
	}

}
