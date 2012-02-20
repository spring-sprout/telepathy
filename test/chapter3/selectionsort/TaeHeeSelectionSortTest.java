package chapter3.selectionsort;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaeHeeSelectionSortTest {
	SelectionSort selectionSort = new TaeHeeSelectionSort();
	
	@Test
	public void testSort(){
		int[] testValue = {1, 3, 2, 5, 6};
		int[] sortedValue = selectionSort.sort(testValue);
		assertNotNull( sortedValue );
		assertEquals( testValue.length, sortedValue.length );
		
		// 정렬이 됐는지 검증
		assertSort(sortedValue );
		
		// 배열요소가 2개일 때의 테스트
		testValue = new int[]{4, 1};
		sortedValue = selectionSort.sort(testValue);
		assertSort(sortedValue);
		
		// 배열요소가 1개일 때의 테스트
		testValue = new int[]{4};
		sortedValue = selectionSort.sort(testValue);
		assertSort(sortedValue);
		
		// 음수가 포함된 배열인 경우의 테스트
		testValue = new int[]{-1, -4, -2, -1, 6};
		sortedValue = selectionSort.sort(testValue);
		assertSort(sortedValue);
		
		// 같은 수로 이루어진 배열일 경우의 테스트
		testValue = new int[]{1,1,1,1,1,1,1};
		sortedValue = selectionSort.sort(testValue);
		assertSort(testValue);
		
		// 빈 배열이나 null을 넘겼을 때는 오류가 나야함.
		try{
			selectionSort.sort(new int[]{});
			fail();
		}catch(NullPointerException ex){
			
		}
	}
	
	private boolean assertSort(int[] input){
		boolean isSort = true;
		for(int i = 0 ; i < input.length - 1; i++){
			isSort =  input[i] <= input[i+1];
			if( !isSort ){
				return false;
			}
		}
		return isSort;
	}
}
