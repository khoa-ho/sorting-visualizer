package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

/***
 * This class represents a compare event happening in any sorting algorithms.
 * 
 * @author zhanghon hokhoa
 */
public class CompareEvent<T extends Comparable<T>> implements SortEvent<T> {
    private int index1;
    private int index2;

    /***
     * This is the constructor method for a CompareEvent object.
     * 
     * @param index1
     *            a natural number
     * @param index2
     *            a natural number
     * @return a CompareEvent object with its two fields set to the two given
     *         integers, which are indices of the to-be-compared elements
     */
    public CompareEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    /***
     * Applies this current CompareEvent object to a given array list
     * 
     * @param arr
     *            an array list
     */
    public void apply(ArrayList<T> arr) {
        arr.get(index1).compareTo(arr.get(index2));
    }

    /***
     * Gets the affected indices of a comparison event
     * 
     * @return indices of the elements that were compared
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(index1);
        list.add(index2);
        return list;
    }

    /***
     * Checks whether a CompareEvent object is emphasized
     * 
     * @return false by default
     */
    public boolean isEmphasized() {
        return false;
    }
}
