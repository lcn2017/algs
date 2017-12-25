package algs.sort;

public class BubbleSort {
	public static int[] sort(int[] array) {
		int length = array.length;
		int lastExcLocation = length - 1;
		int excPosition = length - 1;

		for (int i = 0; i < length; i++) {
			boolean isExchange = false;

			for (int j = 0; j < lastExcLocation; j++) {
				if (SortUtil.less(array[j + 1], array[j])) {
					SortUtil.exchange(array, j, j + 1);
					isExchange = true;
					excPosition = j;
				}
			}

			lastExcLocation = excPosition;

			if (!isExchange) {
				assert (SortUtil.isSorted(array));
				return array;
			}
		}

		return null;
	}
}
