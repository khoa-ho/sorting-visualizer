package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T extends Comparable<T>> implements SortEvent<T> {
    private T value;
    private int destId;

    public CopyEvent(T value, int destId) {
        this.value = value;
        this.destId = destId;
    }

    public void apply(ArrayList<T> arr) {
        arr.set(destId, value);
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(destId);
        return list;
    }

    public boolean isEmphasized() {
        return true;
    }
}
