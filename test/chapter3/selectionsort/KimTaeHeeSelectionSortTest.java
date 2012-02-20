package chapter3.selectionsort;

import static org.junit.Assert.*;
import static chapter3.AssertSortUtil.*;

import java.util.Random;

import org.junit.Test;

public class KimTaeHeeSelectionSortTest {
	SelectionSort selectionSort = new KimTaeHeeSelectionSort();
	
	@Test
	public void testSort(){
		// 임의의 난수 10개를 생성하여 정렬을 테스트한다.
		int[] testValue = new int[10];
		Random random = new Random();
		
		for(int i = 0; i < testValue.length; i++){
			testValue[i] = random.nextInt();
		}
		
		assertSort(selectionSort.sort(testValue));
		
		// 배열요소가 2개일 때의 테스트
		testValue = new int[]{4, 1};
		assertSort(selectionSort.sort(testValue));
		
		// 배열요소가 1개일 때의 테스트
		testValue = new int[]{4};
		assertSort(selectionSort.sort(testValue));
		
		// 같은 수로 이루어진 배열일 경우의 테스트
		testValue = new int[]{1,1,1,1,1,1,1};
		assertSort(selectionSort.sort(testValue));
		
		// 빈 배열을 넘겼을 때는 IllegalArgumentException이 나야함.
		try{
			selectionSort.sort(new int[]{});
			fail();
		}catch(IllegalArgumentException ex){
			
		}
	}
	

	
}
