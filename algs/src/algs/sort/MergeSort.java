package algs.sort;

import java.util.Arrays;

public class MergeSort {
	private final static int CUTOFF = 8;

	public static int[] sort(int[] array, int lo, int high) {
		if (high <= lo)
			return null;

		if (high <= lo + CUTOFF) {
			InsertionSort.sort(Arrays.copyOfRange(array, lo, high + 1));
		}

		int mid = lo + (high - lo) / 2;
		int[] aux = new int[array.length];
		sort(array, lo, mid);
		sort(array, mid + 1, high);
		return merge(array, aux, lo, mid, high);
	}

	public static int[] sortBU(int[] array) {

		int length = array.length;
		int[] aux = new int[length];

		for (int step = 1; step < length; step = 2 * step) {
			for (int location = 0; location < (length - step); location += 2 * step) {
				merge(array, aux, location, location + step - 1, Math.min(location + 2 * step - 1, length - 1));
			}
		}

		return array;
	}

	private static int[] merge(int[] array, int[] aux, int lo, int mid, int high) {
		if (array[mid] <= array[mid + 1]) {
			return array;
		}

		int length = array.length;

		for (int i = 0; i < length; i++) {
			aux[i] = array[i];
		}

		int leftPosition = lo;
		int rightPosition = mid + 1;

		for (int index = lo; index <= high; index++) {
			if (leftPosition > mid) {
				array[index] = aux[rightPosition++];
			} else if (rightPosition > high) {
				array[index] = aux[leftPosition++];
			} else if (aux[rightPosition] < aux[leftPosition]) {
				array[index] = aux[rightPosition++];
			} else {
				array[index] = aux[leftPosition++];
			}
		}

		// We can use the following way to save time of determine whether the left or
		// right arrays are exhausted. But it will cause unstable results.
		// for (int k = lo; k <= mid; k++) {
		// aux[k] = a[k];
		// }

		// for (int k = mid + 1;k <= hi; k++) {
		// aux[k] = a[hi - k + mid + 1];
		// }

		// int i = lo, j = hi;

		// for (int k = lo; k <= hi; k++)
		// if (aux[i] <= aux[j]) a[k] = aux[i++];
		// else a[k] = aux[j--];
		// }

		assert (SortUtil.isSorted(array));
		return array;
	}
}
