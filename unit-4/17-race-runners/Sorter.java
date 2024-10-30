import java.util.Comparator;

public class Sorter {
    public static void sort(Runner[] runners, Comparator<Runner> comp) {
        quickSort(runners, 0, runners.length - 1, comp);
    }

    private static void quickSort(Runner[] runners, int low, int high, Comparator<Runner> comp) {
        if (low < high) {
            int pivotIndex = partition(runners, low, high, comp);
            quickSort(runners, low, pivotIndex - 1, comp);
            quickSort(runners, pivotIndex + 1, high, comp);
        }
    }

    private static int partition(Runner[] runners, int low, int high, Comparator<Runner> comp) {
        Runner pivot = runners[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comp.compare(runners[j], pivot) <= 0) {
                i++;
                swap(runners, i, j);
            }
        }

        swap(runners, i + 1, high);
        return i + 1;
    }

    private static void swap(Runner[] runners, int i, int j) {
        Runner temp = runners[i];
        runners[i] = runners[j];
        runners[j] = temp;
    }
}