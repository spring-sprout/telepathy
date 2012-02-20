package chapter3.bubblesort;

public class HanwooBubbleSort implements BubbleSort {

	@Override
	public int[] sort(int[] input) {
		
		for (int checkLastKey = input.length-1; checkLastKey >= 0; checkLastKey--) {
			boolean isSorted = true;
			for (int i = 0; i < checkLastKey; i++) {
				if(input[i] > input[i+1]) {
					int tmpData = input[i];
					input[i] = input[i+1];
					input[i+1] = tmpData;
					isSorted = false;
				}
			}
			if(isSorted) break;
		}
		
		return input;
	}

}
