package chapter3.mergesort;

public class HanwooMergeSort implements MergeSort {

	int i = 0;
	@Override
	public int[] sort(int[] input) {
		
		mergeSort(input, 0, input.length-1, 0);
		
		return input;
	}
	
	private void mergeSort(int[] input, int firstKey, int secondKey, int check) {

		if(firstKey < secondKey) {
			int centerKey = ((firstKey + secondKey + 2) / 2) - 1;
//			System.out.format("firstKey : %d, secondKey : %d , i : %d, check : %d, center : %d \n", firstKey, secondKey, i++, check, centerKey);
			mergeSort(input, firstKey, centerKey, 1);
			mergeSort(input, centerKey+1, secondKey, 2);
			merge(input, firstKey, centerKey, secondKey);
		}
	}
	
	private void merge(int[] input, int firstKey, int centerKey, int secondKey) {
		int i = firstKey;
		int j = centerKey + 1;
		int tmpKey = 0;
		int[] tmpData = new int[input.length];
		
		// 앞부분 정렬과 뒷부분 정렬을 비교해서 temp에 넣는다.
		while(i <= centerKey && j <= secondKey) {
			if(input[i] <= input[j])
				tmpData[tmpKey++] = input[i++];
			else
				tmpData[tmpKey++] = input[j++];
		}

		// 앞부분에 남은 데이터를 넣는다.
		while(i <= centerKey) {
			tmpData[tmpKey++] = input[i++];
		}

		// 뒷부분에 남은 데이터를 넣는다.
		while(j <= secondKey) {
			tmpData[tmpKey++] = input[j++];
		}
		
		// 데이터를 정렬된 temp데이터로 바꾼다. 
		i = firstKey;
		tmpKey = 0;
		while(i <= secondKey) {
			input[i++] = tmpData[tmpKey++];
		}
	}

}
