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

    private void printArray(int[] input) {
        System.out.print(" Current array state: ");
        for (int i : input) {
            System.out.print(" " + i);
        }

        System.out.println("");
    }
}
