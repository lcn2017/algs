package algs.sort;

public class SelectionSort {
	public static int[] sort(int[] array) {
		int length = array.length;
		int index = 0;

		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (SortUtil.less(array[j], array[index])) {
					index = j;
				}
			}

			SortUtil.exchange(array, i, index);
			index = i + 1;
		}

		assert (SortUtil.isSorted(array));
		return array;
	}
}
