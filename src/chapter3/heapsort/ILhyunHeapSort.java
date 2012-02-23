package chapter3.heapsort;

/**
 * @author ihseo
 */
public class ILhyunHeapSort implements HeapSort {

	@Override
	public int[] sort(int[] input) {
		buildHeap(input, input.length-1);
		
		int size = input.length-1;
		for(int loop = size; loop > 0; loop--){
			int temp = input[0];
			input[0] = input[loop];
			input[loop] = temp;
			
			heapify(input, 0, loop-1);
		}
		
		return input;
	}
	
	private void buildHeap(int[] input, int lastIndex) {
		for(int loop = (lastIndex/2); loop >= 0; loop--){
			heapify(input, loop, lastIndex);
		}
	}
	
	private void heapify(int[] input, int rootIndex, int lastIndex) {
		//System.out.println("____________________________");
		//for(int i :input) System.out.print(i + "\t");
		//System.out.println();
		//System.out.println("____________________________");
		
		int leftIndex = 2*rootIndex;
		int rightIndex = 2*rootIndex+1;
		int tempIndex;
		
		// 자식이 둘인 경우
		if(rightIndex <= lastIndex) {
			if(input[leftIndex] < input[rightIndex]) tempIndex = rightIndex;
			else tempIndex = leftIndex;
		}
		// 왼쪽 자식만 있는 경우
		else if(leftIndex <= lastIndex) tempIndex = leftIndex;
		// 자식이 없는 경우
		else return;
		
		if(input[tempIndex] > input[rootIndex]) {
			int temp = input[tempIndex];
			input[tempIndex] = input[rootIndex];
			input[rootIndex] = temp;
			
			heapify(input, tempIndex, lastIndex);
		}
	}

}
