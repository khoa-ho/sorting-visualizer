package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;

public class Sorts {

    private static <T> void swap(ArrayList<T> l, int i, int j) {
        T temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }

    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(ArrayList<T> l) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        for (int i = 0; i < l.size(); i++) {
            int lowestIndex = i;
            for (int j = i; j < l.size(); j++) {
                events.add(new CompareEvent<>(j, lowestIndex));
                if (l.get(j).compareTo(l.get(lowestIndex)) < 0) {
                    lowestIndex = j;
                }
            }
            swap(l, i, lowestIndex);
            events.add(new SwapEvent<>(i, lowestIndex));
        }
        return events;
    }

    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> l) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        for (int i = 0; i < l.size(); i++) {
            int j = i;
            events.add(new CompareEvent<>(j - 1, j));
            for (j = i; j > 0 && l.get(j - 1).compareTo(l.get(j)) > 0; j--) {
                swap(l, j - 1, j);
                events.add(new SwapEvent<>(j - 1, j));
            }
        }
        return events;
    }

    public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(ArrayList<T> l) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < l.size() - 1; i++) {
                events.add(new CompareEvent<>(i, i + 1));
                if (l.get(i).compareTo(l.get(i + 1)) > 0) {
                    isSorted = false;
                    swap(l, i, i + 1);
                    events.add(new SwapEvent<>(i, i + 1));
                }
            }
        }
        return events;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> List<SortEvent<T>> merge(ArrayList<T> l, int lo,
            int mid, int hi) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        Comparable<T>[] temp = (T[]) new Comparable[hi - lo];

        int i = lo;
        int j = mid;
        int k = 0;

        while (i < mid && j < hi) {
            events.add(new CompareEvent<>(i, j));
            if (l.get(i).compareTo(l.get(j)) < 1) {
                temp[k++] = l.get(i++);
            } else {
                temp[k++] = l.get(j++);
            }
        }
        while (i < mid) {
            temp[k++] = l.get(i++);
        }

        while (j < hi) {
            temp[k++] = l.get(j++);
        }

        for (int h = 0; h < temp.length; h++) {
            l.set(h + lo, (T) temp[h]);
            events.add(new CopyEvent<>((T) temp[h], h + lo));
        }
        return events;
    }

    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> l, int lo,
            int hi) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        if (hi > lo + 1) {
            int mid = lo + (hi - lo) / 2;
            List<SortEvent<T>> e1 = mergeSort(l, lo, mid);
            List<SortEvent<T>> e2 = mergeSort(l, mid, hi);
            List<SortEvent<T>> e3 = merge(l, lo, mid, hi);
            events.addAll(e1);
            events.addAll(e2);
            events.addAll(e3);
        }
        return events;
    }

    // Inclusive hi
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(ArrayList<T> l, int lo,
            int hi) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();

        if (lo < hi) {
            // Partition
            T pivot = l.get(hi);
            int i = (lo - 1);
            for (int j = lo; j < hi; j++) {
                events.add(new CompareEvent<>(j, hi));
                if (l.get(j).compareTo(pivot) <= 0) {
                    i++;
                    swap(l, i, j);
                    events.add(new SwapEvent<>(i, j));
                }
            }
            swap(l, i + 1, hi);
            events.add(new SwapEvent<>(i + 1, hi));

            // Recursive calls
            int pivotId = i + 1;
            List<SortEvent<T>> e1 = quickSort(l, lo, pivotId - 1);
            List<SortEvent<T>> e2 = quickSort(l, pivotId + 1, hi);
            events.addAll(e1);
            events.addAll(e2);
        }
        return events;
    }

    public static <T extends Comparable<T>> void eventSort(ArrayList<T> l,
            List<SortEvent<T>> events) {
        for (int i = 0; i < events.size(); i++) {
            events.get(i).apply(l);
        }
    }
}
