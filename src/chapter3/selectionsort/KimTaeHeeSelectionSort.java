package chapter3.selectionsort;


public class KimTaeHeeSelectionSort implements SelectionSort{

	@Override
	public int[] sort(int[] input) {
		if( input.length == 0 ){
			throw new IllegalArgumentException("정렬 대상 배열의 갯수가 0입니다");
		}
		int lastIndex = input.length - 1;
		while( lastIndex > 0 ){
			
			int maxValueIndex = getMaxValueIndex(input, lastIndex);			
			
			// swap
			swap(input, maxValueIndex, lastIndex);
			
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
	private void swap(int[] input, int firstIndex, int secondIndex){
		if( firstIndex != secondIndex ){
			int tempValue = input[secondIndex];
			input[secondIndex] = input[firstIndex];
			input[firstIndex] = tempValue;
		}
	}
}
