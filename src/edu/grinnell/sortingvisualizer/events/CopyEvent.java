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
     * @param value
     *            a to-be-copied Comparable object
     * @param destId
     *            the index of the destination position in the array list
     * @return a CopyEvent object
     */
    public CopyEvent(T value, int destId) {
        this.value = value;
        this.destId = destId;
    }

    /***
     * Applies this current CopyEvent object to a given array list
     * 
     * @param arr
     *            an array list
     */
    public void apply(ArrayList<T> arr) {
        arr.set(destId, value);
    }

    /***
     * Gets the affected index in the destination array list of a copy event
     * 
     * @return an integer array list of the index where the copied value in the
     *         destination array list is at
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(destId);
        return list;
    }
    
    /***
     * Checks whether a CopyEvent object is emphasized
     * 
     * @return true by default
     */
    public boolean isEmphasized() {
        return true;
    }
}
