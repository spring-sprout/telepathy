package chapter3;

public class SortUtil {

	public static void swap(int[] input, int firstIndex, int secondIndex) {
		if( input == null || input.length == 0){
			throw new NullPointerException("교환 대상 배열은 null이거나 갯수가 0일 수 없습니다.");
		}
		
		if( firstIndex < 0 || secondIndex < 0 || firstIndex >= input.length || secondIndex >= input.length){
			throw new IllegalArgumentException("배열첨자가 올바르지 않습니다. firstIndex ; " + firstIndex + 
					", secondIndex : " + secondIndex);
		}
		
		int tempValue = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = tempValue;
		
	}

	public static void valid(int[] input) {
		if( input == null || input.length == 0 ){
			throw new IllegalArgumentException("올바른 정렬대상이 아닙니다.");
		}
	}

}
