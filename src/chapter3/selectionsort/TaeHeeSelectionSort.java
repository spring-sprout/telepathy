package chapter3.selectionsort;


public class TaeHeeSelectionSort implements SelectionSort{

	@Override
	public int[] sort(int[] input) {
		if( input.length == 0 ){
			throw new NullPointerException("정렬 대상 배열의 갯수가 0입니다");
		}
		int lastIndex = input.length - 1;
		while( lastIndex > 1 ){
			
			int maxValueIndex = getMaxValueIndex(input, lastIndex);			
			
			// swap
			swap(input, maxValueIndex, lastIndex);
			lastIndex--;
		}
		return input;
	}
	
	private int getMaxValueIndex(int input[], int lastIndex){
		if( input == null ){
			throw new NullPointerException("올바르지 않은 배열 파라메터입니다.");
		}
		
		if( lastIndex < 0 ){
			throw new IllegalArgumentException("lastIndex는 음수가 될 수 없습니다.");
		}
		int maxValue = input[0];
		int maxValueIndex = 0;
		for( int i = 0 ; i <= lastIndex; i++){
			if( maxValue <= input[i]){
				maxValue = input[i];
				maxValueIndex = i;
			}
		}
		return maxValueIndex;
	}
	private void swap(int[] input, int firstIndex, int secondIndex){
		if( firstIndex != secondIndex && firstIndex < input.length && secondIndex < input.length ){
			int tempValue = input[secondIndex];
			input[secondIndex] = input[firstIndex];
			input[firstIndex] = tempValue;
		}
	}
}
