package chapter3.radixsort;

import java.util.LinkedList;
import java.util.Queue;

import chapter3.Sort;

public class HanwooRadixSort implements Sort {

	private final static int MAX_LENGTH = 10; 

	@Override
	public void sort(int[] input) {
		radixSort(input, input.length, getMaxLength(input));
	}
	
	@SuppressWarnings("unchecked")
	private void radixSort(int[] input, int inputCount, int maxLength) {
		
		for (int i = 1; i <= maxLength; i++) {
			Queue<Integer>[] dataList = new LinkedList[MAX_LENGTH];
			for (int j : input) {
				int data = (int) Math.floor((j % (int)Math.pow(10, i)) / (int)Math.pow(10, i-1));

				if(dataList[data] == null)	dataList[data] = new LinkedList<Integer>();
				dataList[data].offer(j);
			}

			for (int k = 0, m = 0; k < MAX_LENGTH; k++) {
				if(dataList[k] != null) {
					while(dataList[k].peek() != null)
						input[m++] = dataList[k].poll();
				}
			}
			
			for (int b : input) {
				System.out.println(b);	
			}
			System.out.println("------------------------------");	
			
		}
	}
	
	private int getMaxLength(int[] input) {
		int maxLength = 0;
		
		for (int i : input) {
			int length = Integer.toString(i).length();
			if(maxLength < length)
				maxLength = length;
		}

		return maxLength;
	}
}
