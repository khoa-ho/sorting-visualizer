package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T extends Comparable<T>> implements SortEvent<T> {
    private int index1;
    private int index2;

    public CompareEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    public void apply(ArrayList<T> arr) {
        arr.get(index1).compareTo(arr.get(index2));
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(index1);
        list.add(index2);
        return list;
    }

    public boolean isEmphasized() {
        return false;
    }
}
