package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

/***
 * This class represents a swap event happening in any sorting algorithms.
 * 
 * @author zhanghon hokhoa
 */
public class SwapEvent<T extends Comparable<T>> implements SortEvent<T> {
    private int index1;
    private int index2;
    
    /***
     * This is the constructor method for a SwapEvent object.
     * 
     * @param index1,
     *            a natural number
     * @param index2,
     *            a natural number
     * @return a SwapEvent object, with its two fields set to the two given
     *         integers, which are the two indices of the to-be-swapped elements
     */
    public SwapEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    /***
     * Apply this current SwapEvent object to a given array list.
     * 
     * @param arr,
     *            an array list
     */
    public void apply(ArrayList<T> arr) {
        T temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }
    
    /***
     * Get the affected indices of a swap event.
     * 
     * @return an integer array list of the indices of elements that were swapped
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(index1);
        list.add(index2);
        return list;
    }
    /***
     * Answer the question that whether a SwapEvent object is emphasized.
     * 
     * @return true, a boolean value
     */
    public boolean isEmphasized() {
        return true;
    }
}
