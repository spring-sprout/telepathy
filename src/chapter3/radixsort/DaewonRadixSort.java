package chapter3.radixsort;

import java.util.ArrayList;
import java.util.List;

import chapter3.Sort;

public class DaewonRadixSort implements Sort {

	List<List<Integer>> radixStore;

	public DaewonRadixSort() {
		radixStore = new ArrayList<List<Integer>>(10);
		for (int i = 0; i < 10; i++) {
			radixStore.add(new ArrayList<Integer>());
		}
	}

	@Override
	public void sort(int[] input) {
		int maxValue = getMaxValue(input);
		int maxDigit = (int)Math.log10(maxValue) + 1;
		System.out.printf("MaxValue:%d, MaxDigit:%d\n", maxValue, maxDigit);

		radixSort(input, maxDigit);
	}

	public void radixSort(int[] input, int numOfDigit) {
		for (int digit = 1; digit <= numOfDigit; digit++) {
			for (int j = 0; j < input.length; j++) {
				int inputValue = input[j];
				int digitValue = getDigitValue(inputValue, digit);
				System.out.printf("Idx:%d, InputValue:%d, Digit:%d, DigitValue:%d\n", j, inputValue, digit, digitValue);
				radixStore.get(digitValue).add(inputValue);
			}

			int idx = 0;
			for (int i = 0; i < radixStore.size(); i++) {
				List<Integer> values = radixStore.get(i);
				for (Integer value : values) {
					System.out.printf("Idx:%d, Value:%d \n", idx, value);
					input[idx++] = value;
				}
				values.clear();
			}
		}
	}

	private int getDigitValue(int value, int digit) {
		return (int)((value % Math.pow(10, digit)) / Math.pow(10, digit - 1));
	}

	private int getMaxValue(int[] input) {
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max) {
				max = input[i];
			}
		}
		return max;
	}

}
