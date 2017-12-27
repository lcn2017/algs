package algs.sort;

import java.util.Arrays;

public class QuickSort {
	private static void sort(int[] array, int lo, int high) {
		if (lo >= high) {
			return;
		}

		// When the distance of lo and high less than CUTOFF(8), We can use insertion
		// sort instead of quick sort
		// if (high <= lo + CUTOFF) {
		// InsertionSort.sort(array);
		// return;
		// }

		int index = partition(array, lo, high);
		sort(array, lo, index - 1);
		sort(array, index + 1, high);
	}

	private static void selectIndex(int[] array, int lo, int high) {
		int mid = lo + (high - lo) / 2;
		int loValue = array[lo];
		int midValue = array[mid];
		int highValue = array[high];

		int max = loValue >= midValue ? loValue : midValue;
		max = max >= highValue ? max : highValue;

		int min = loValue >= midValue ? midValue : loValue;
		min = min >= highValue ? highValue : min;

		int medium = loValue + midValue + highValue - max - min;

		if (medium == midValue)
			SortUtil.exchange(array, mid, lo);
		if (medium == highValue)
			SortUtil.exchange(array, high, lo);
	}

	// This method will put the value that have the same value as comparison value
	// around the index, But it will cause unstable results.
	private static int handlingSameKeyPartition(int[] array, int lo, int high) {
		selectIndex(array, lo, high);
		int lessThanComparandIndex = lo;
		int greaterThanComparandIndex = high + 1;
		int compare = array[lo];
		int leftEqualCompareIndex = lo + 1;
		int rightEqualCompareIndex = high;

		while (true) {
			while (array[++lessThanComparandIndex] <= compare) {
				if (array[lessThanComparandIndex] == compare) {
					SortUtil.exchange(array, lessThanComparandIndex, leftEqualCompareIndex);
					leftEqualCompareIndex++;
				}

				if (lessThanComparandIndex == high) {
					break;
				}
			}

			while (array[--greaterThanComparandIndex] > compare) {
				if (array[greaterThanComparandIndex] == compare) {
					SortUtil.exchange(array, greaterThanComparandIndex, rightEqualCompareIndex);
					rightEqualCompareIndex--;
				}

				if (greaterThanComparandIndex == lo) {
					break;
				}
			}

			if (lessThanComparandIndex >= greaterThanComparandIndex) {
				break;
			}

			SortUtil.exchange(array, lessThanComparandIndex, greaterThanComparandIndex);
		}

		int compareIndex = greaterThanComparandIndex;

		for (int leftIndex = lo; leftIndex < leftEqualCompareIndex; leftIndex++, greaterThanComparandIndex--) {
			SortUtil.exchange(array, greaterThanComparandIndex, leftIndex);
		}

		greaterThanComparandIndex += leftEqualCompareIndex + 1;
		for (int rightIndex = 0; rightIndex < high
				- rightEqualCompareIndex; rightIndex++, greaterThanComparandIndex++) {
			SortUtil.exchange(array, greaterThanComparandIndex, high - rightIndex);
		}

		return compareIndex;
	}

	private static int partition(int[] array, int lo, int high) {
		selectIndex(array, lo, high);
		int lessThanComparandIndex = lo;
		int greaterThanComparandIndex = high + 1;
		int compare = array[lo];

		while (true) {
			while (array[++lessThanComparandIndex] <= compare) {
				if (lessThanComparandIndex == high) {
					break;
				}
			}

			while (array[--greaterThanComparandIndex] > compare) {
				if (greaterThanComparandIndex == lo) {
					break;
				}
			}

			if (lessThanComparandIndex >= greaterThanComparandIndex) {
				break;
			}

			SortUtil.exchange(array, lessThanComparandIndex, greaterThanComparandIndex);
		}

		return greaterThanComparandIndex;
	}

	public static void main(String[] args) {
		int[] array = { 2, 5, 1, 2, 3, 5, 1, 8, 5, 5, 8 };
		sort(array, 0, array.length - 1);
		System.out.print(Arrays.toString(array));
	}
}
