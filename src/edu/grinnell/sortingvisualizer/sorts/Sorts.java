package sorts;

import java.util.Arrays;

public class Sorts {
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lowestIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            swap(arr, i, lowestIndex);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] arr, int lo, int mid, int hi) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[arr.length];
        int i = lo;
        int j = mid;
        int k = 0;
        while (i < mid && j < hi) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        if (i == mid) {
            while (j < hi) {
                temp[k++] = arr[j++];
            }
        } else if (j == hi) {
            while (i < mid) {
                temp[k++] = arr[i++];
            }
        }
        for (int h = 0; h < k; h++) {
            arr[h] = temp[h];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 4, 6, 1, 2, 9, 9, 10, 4, 2 };
        insertionSort(arr);
        // System.out.println(Arrays.toString(arr));
        Integer[] arr1 = new Integer[] { 4, 6, 7, 9, 10, 10, 11, 2, 3, 5, 6, 8 };
        merge(arr1, 0, 7, arr1.length);
        System.out.println(Arrays.toString(arr1));
    }
}
