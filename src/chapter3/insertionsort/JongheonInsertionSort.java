package chapter3.selectionsort;
/**
 * @author maxmir
 *
 */
public class JongheonInsertionSort implements SelectionSort {
	
	public int[] sort(int[] input) {
		int loc = 0;
		int newItem = 0;
		
		for (int i = 1; i < input.length; i++) {
			// i++이 항상 새로 삽입할 값(newItem)을 가리키도록 함.
			loc = i - 1; // 정렬된 배열의 마지막 위치
			newItem = input[i];
			
			// 정렬이 완료될때까지 반복.
			// 항상 newItem 이전의 배열이 정렬되어 있도록 함.
			while ( loc >= 0 && newItem < input[loc]) {
				int temp = input[loc + 1];
				input[loc + 1] = input[loc];
				input[loc] = temp;
				
				loc--;
			} // while
			
		} // for
		return input;
	} // sort()
	
} // class
