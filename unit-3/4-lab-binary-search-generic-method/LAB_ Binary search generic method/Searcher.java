import java.util.*;

public class Searcher<T> {
	// Returns the index of the key in the sorted array, or -1 if the
	// key is not found.
	public static <T> int binarySearch(T[] array, int arraySize, T key,
			Comparator<T> comparer) {

		/* Code */
		int low = 0;
		int high = arraySize - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (comparer.compare(array[mid], key) == 0) {
				return mid;
			} else if (comparer.compare(array[mid], key) < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
		/* Code End */
	}
}