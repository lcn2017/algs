package algs.sort;

public class InsertionSort {
	public static int[] sort(int[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			for (int j = i; j > 0 && SortUtil.less(array[j], array[j - 1]); j--) {
				SortUtil.exchange(array, j, j - 1);
			}
		}

		assert (SortUtil.isSorted(array));
		return array;
	}
}
