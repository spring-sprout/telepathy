package chapter3.bubblesort;

public class KimTaeHeeBubbleSort implements BubbleSort{

	@Override
	public int[] sort(int[] input) {
		if( input.length == 0 ){
			throw new IllegalArgumentException("배열 갯수가 0입니다.");
		}
		int lastIndex = input.length - 1;
		for(; lastIndex > 0 ; lastIndex--){
			boolean isSorted = true;
			for(int i = 0; i < lastIndex; i++){
				if( input[i] > input[i+1]){
					int tempValue = input[i];
					input[i] = input[i + 1];
					input[i + 1] = tempValue;
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
