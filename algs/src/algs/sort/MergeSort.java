package algs.sort;

public class MergeSort {
	public static int[] sort(int[] array, int lo, int high) {
		if (high <= lo)
			return null;

		int mid = lo + (high - lo) / 2;
		int[] aux = new int[array.length];
		sort(array, lo, mid);
		sort(array, mid + 1, high);

		if (array[mid + 1] >= array[mid]) {
			return null;
		}

		return merge(array, aux, lo, mid, high);

	}

	public static int[] sortBU(int[] array) {
		int length = array.length;
		int[] aux = new int[length];

		for (int i = 1; i < length; i = 2 * i) {
			for (int lo = 0; lo < length - i; lo += 2 * i) {
				merge(array, aux, lo, lo + i - 1, Math.min(lo + 2 * i - 1, length - 1));
			}
		}

		return array;
	}

	private static int[] merge(int[] array, int[] aux, int lo, int mid, int high) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			aux[i] = array[i];
		}

		int leftPosition = lo;
		int rightPosition = mid + 1;

		for (int index = 0; index <= high; index++) {
			if (leftPosition > mid) {
				array[index] = aux[leftPosition++];
			} else if (rightPosition > high) {
				array[index] = aux[leftPosition++];
			} else if (aux[rightPosition] < aux[leftPosition]) {
				array[index] = aux[rightPosition++];
			} else {
				array[index] = aux[leftPosition++];
			}
		}

		assert (SortUtil.isSorted(array));
		return array;
	}
}
