package chapter3.heapsort;

import chapter3.Sort;
import chapter3.SortUtil;

public class KimTaeHeeHeapSort implements Sort{

	@Override
	public void sort(int[] input) {
		buildHeap(input);
		for(int i = input.length - 1; i > 0; i--){
			SortUtil.swap(input, 0, i);
			heapify(input, 0, i - 1);
		}
		SortUtil.reverse(input);
		for( int i : input ){
			System.out.print( i );
		}
	}
	
	/**
	 * 힙을 만든다.
	 * @param input
	 */
	public void buildHeap(int input[]){
		int lastIndex = input.length - 1;
		for( int i = lastIndex  / 2; i > -1 ; i--){
			System.out.println(i);
			heapify(input, i, lastIndex);
		}
	}
	
	/**
	 * input[rootPoint]를 루트로 하는 트리를
	 * 합성질을 만족하도록 수선한다.
	 * @param input
	 * @param rootPoint
	 * @param lastIndex
	 */
	private void heapify(int[] input, int rootPoint, int lastIndex){
		int left = 2 * rootPoint;
		int right = (2 * rootPoint) + 1;
		int smaller;
		if( right <= lastIndex ){
			if( input[left] < input[right] ){
				smaller = left;
			}else{
				smaller = right;
			}
		}else if(left <= lastIndex){
			smaller = left;
		}else{
			return;
		}
		
		// 재귀적 조정
		if( input[smaller] < input[rootPoint] ){
			SortUtil.swap(input, rootPoint, smaller);
			heapify(input, smaller, lastIndex);
		}
	}
}
