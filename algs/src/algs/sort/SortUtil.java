package algs.sort;

public class SortUtil {
	public static boolean isSorted(int[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	public static boolean isSorted(int[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static boolean less(int v, int w) {
		return v < w;
	}

	public static int[] exchange(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		return array;
	}
}
