package chapter4;

public class DaewonAverageLinearTimeSelect {

	public int select(int[] input, int selectOrder) {
		return select(input, 0, input.length - 1, selectOrder);
	}

	public int select(int[] input, int start, int end, int selectOrder) {
		if (start == end) {
			return input[start];
		}

		int partitionIdx = partition(input, start, end);

		int k = partitionIdx - start + 1;
		if (selectOrder < k) {
			return select(input, start, partitionIdx - 1, selectOrder);

		} else if (selectOrder > k) {
			return select(input, partitionIdx + 1, end, selectOrder - k);

		} else {
			return input[partitionIdx];
		}
	}

	private int partition(int[] input, int firstIdx, int lastIdx) {
		int partitionIdx = firstIdx;
		int partitionVal = input[lastIdx];

		for (int j = firstIdx; j < lastIdx; j++) {
			if (input[j] <= partitionVal)
				swap(input, partitionIdx++, j);
		}

		swap(input, partitionIdx, lastIdx);

		return partitionIdx;
	}

	private void swap(int[] input, int idx1, int idx2) {
		int temp = input[idx2];
		input[idx2] = input[idx1];
		input[idx1] = temp;
	}

}
