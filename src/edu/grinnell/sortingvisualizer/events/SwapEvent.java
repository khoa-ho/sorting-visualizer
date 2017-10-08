package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T extends Comparable<T>> implements SortEvent<T> {
    private int index1;
    private int index2;

    public SwapEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    public void apply(ArrayList<T> arr) {
        T temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(index1);
        list.add(index2);
        return list;
    }

    public boolean isEmphasized() {
        return true;
    }
}
