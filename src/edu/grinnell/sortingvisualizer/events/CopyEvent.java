package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

/***
 * This class represents a copy event happening in any sorting algorithms.
 * 
 * @author zhanghon hokhoa
 */
public class CopyEvent<T extends Comparable<T>> implements SortEvent<T> {
    private T value;
    private int destId;

    /***
     * This is the constructor method for a CopyEvent object.
     * 
     * @param value,
     *            a to-be-copied java object
     * @param destId,
     *            a natural number which is the position where the copy of value is
     *            in the destination array list
     * @return a CopyEvent object, with its two fields set to the two input values,
     *         respectively
     */
    public CopyEvent(T value, int destId) {
        this.value = value;
        this.destId = destId;
    }

    /***
     * Apply this current CopyEvent object to a given array list.
     * 
     * @param arr,
     *            an array list
     */
    public void apply(ArrayList<T> arr) {
        arr.set(destId, value);
    }

    /***
     * Get the affected index in the destination array list of a copy event.
     * 
     * @return an integer array list of the index where the copied value is in the
     *         destination array list
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(destId);
        return list;
    }
    
    /***
     * Answer the question that whether a CopyEvent object is emphasized.
     * 
     * @return true, a boolean value
     */
    public boolean isEmphasized() {
        return true;
    }
}
