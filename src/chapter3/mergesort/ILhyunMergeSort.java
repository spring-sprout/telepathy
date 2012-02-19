package chapter3.mergesort;

/**
 * @author ihseo
 */
public class ILhyunMergeSort implements MergeSort {

	@Override
	public int[] sort(int[] input) {
		mergeSort(input, 0, input.length-1);
		return input;
	}
	
	public void mergeSort(int[] input, int startIndex, int lastIndex){
//		System.out.println("merge sort :  " + startIndex + " , "+ lastIndex);
		if(startIndex < lastIndex){
			int halfIndex = (startIndex + lastIndex)/2;
			mergeSort(input, startIndex, halfIndex);
			mergeSort(input, halfIndex+1, lastIndex);
			
			merge(input, startIndex, halfIndex, lastIndex);
		}
	}
	
	public void merge(int[] input, int startIndex, int halfIndex, int lastIndex){
//		System.out.println("--> "+ startIndex +" , " +  halfIndex + " , " +lastIndex);
		int i = startIndex;
		int j = halfIndex+1;
		int t = 0;
		
		int[] temp = new int[input.length]; // 두 부분 배열의 병합에 필요한 임시 배열
		
		while(i <= halfIndex && j <= lastIndex){
			if(input[i] < input[j]){
				temp[t++] = input[i++];
			}
			else temp[t++] = input[j++];
		}
		
		while(i <= halfIndex){
			temp[t++] = input[i++];
		}
		
		while(j <= lastIndex) {
			temp[t++] = input[j++];
		}
		
		// 변수 초기화
		i = startIndex;
		t = 0;
		
		// 정렬
		while(i <= lastIndex){
			input[i++] = temp[t++];
		}
	}

}
