import org.junit.jupiter.api.Test;

public class SortMethods {
    @Test
    public void insertionSort() throws Exception {
        int[] input = new int[]{7, 10, 3, 2, 6};
        for (int i = 1, j, key; i < input.length; i++) {
            key = input[i];
            j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = key;
        }
        printArray(input);
    }

    @Test
    public void anotherInsertionSort() throws Exception {
        int[] input = new int[]{7, 10, 3, 2, 6};
        for (int i = 0, temp; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j - 1] > input[j]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
        printArray(input);
    }

    @Test
    public void selectionSort() throws Exception {
        int[] input = new int[]{7, 10, 3, 2, 6};
        for (int i = 0, min, temp; i < input.length; i++) {
            min = i;
            for (int j = i; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            temp = input[min];
            input[min] = input[i];
            input[i] = temp;
        }
        printArray(input);
    }

    @Test
    public void bubbleSort() throws Exception {
        int[] input = new int[]{7, 10, 3, 2, 6};
        for (int i = 0; i < input.length; i++) {
            for (int j = 0, temp; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        printArray(input);
    }

    @Test
    public void shellSort() throws Exception {
        int[] input = new int[]{7, 10, 3, 2, 6, 8, 1, 4, 5};
        int h = 1;
        while (h < input.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < input.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (input[j] < input[j - h]) {
                        int temp = input[j];
                        input[j] = input[j - h];
                        input[j - h] = temp;
                    }
                }

            }
            h = h / 3;
        }
        printArray(input);
    }

    @Test
    public void mergeSort() {
        int[] input = new int[]{7, 10, 3, 2, 6, 8, 1, 4, 5};
        int[] auxArray = new int[input.length];
        int low = 0;
        int high = input.length - 1;
        System.arraycopy(input, 0, auxArray, 0, input.length);
        mergeSortImpl(input, auxArray, low, high);
        printArray(input);
    }

    private void mergeSortImpl(int[] input, int[] auxArray, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        mergeSortImpl(input, auxArray, low, mid);
        mergeSortImpl(input, auxArray, mid + 1, high);
        mergeSubArrays(input, auxArray, low, high, mid);
    }

    private void mergeSubArrays(int[] input, int[] auxArray, int low, int high, int mid) {
        int i = low;
        int j = mid + 1;
        for (int m = low; m <= high; m++) {
            auxArray[m] = input[m];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                input[k] = auxArray[j++];
            } else if (j > high) {
                input[k] = auxArray[i++];
            } else if (auxArray[i] < auxArray[j]) {
                input[k] = auxArray[i++];
            } else input[k] = auxArray[j++];
        }
    }

    @Test
    void bottomUpMergeSort() {
        int[] input = new int[]{7, 10, 3, 2, 6, 8, 1, 4, 5, 11};
        int N = input.length;
        int[] auxArray = new int[N];
        System.arraycopy(input, 0, auxArray, 0, N);

        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int j = 0; j < N - sz; j += sz + sz) {
                mergeSubArrays(input, auxArray, j,  Math.min(j + sz +sz -1, N - 1), j + sz -1);
            }
        }
        printArray(input);
    }

    @Test
    void quickSort() {
        // Input array should be shuffled before sorting.
        // Bad performance with duplicates and already sorted array.
        int[] input = new int[]{7, 10, 3, 2, 6, 8, 1, 4, 5};
        int low = 0;
        int high = input.length - 1;
        quickSortImpl(input, low, high);
        printArray(input);
    }

    private void quickSortImpl(int[] input, int low, int high){
        if(high<=low) return;
        int j = partitionForQuickSort(input, low, high);
        quickSortImpl(input, low ,j-1);
        quickSortImpl(input, j+1 , high);
    }

    private int partitionForQuickSort(int[] input, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (input[++i] <= input[low])
                if (i == high) break;
            while (input[low] <= input[--j])
                if (j == low) break;
            if (i >= j) break;

            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }

        int temp = input[low];
        input[low] = input[j];
        input[j] = temp;
        return j;
    }

    private void printArray(int[] input) {
        System.out.print(" Current array state: ");
        for (int i : input) {
            System.out.print(" " + i);
        }

        System.out.println("");
    }
}
