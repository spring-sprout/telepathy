package chapter3.insertsort;

import chapter3.Sort;
import chapter3.SortUtil;

public class KimTaeHeeInsertSort implements Sort{
	
	@Override
	public void sort(int[] input) {
		SortUtil.valid(input);
		for(int i = 1; i < input.length; i++){
			int index = i - 1;
			int indexValue = input[i];
			
			while( index >= 0 && indexValue< input[index] ){
				input[index+1] = input[i];
				index--;
			}
			input[index+1] = indexValue;
		}		
	}

}
