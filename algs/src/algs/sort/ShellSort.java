package algs.sort;

public class ShellSort {
	public static int[] sort(int[] array) {
		int length = array.length;
		int step = 1;

		while (step < length / 3) {
			step = 3 * step + 1;
		}

		while (step >= 1) {
			for (int i = step; i < length; i++) {
				for (int j = i; j >= step && SortUtil.less(array[j], array[j - step]); j -= step) {
					SortUtil.exchange(array, j, j - step);
				}
			}

			step = step / 3;
		}

		assert (SortUtil.isSorted(array));
		return array;
	}
}
