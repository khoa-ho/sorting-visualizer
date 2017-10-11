package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

/***
 * This is an interface of important events happening when sorting an array list
 * using a sorting algorithm.
 * 
 * @author zhanghon hokhoa
 * 
 */
public interface SortEvent<T extends Comparable<T>> {
    // Apply a sort event to l. Implementation and detailed documentation can be
    // found in each event's class.
    public void apply(ArrayList<T> l);

    // Get the affected indices involved in a sort event. Implementation and detailed
    // documentation can be found in each event's class.
    public List<Integer> getAffectedIndices();

    // Return true if the event is emphasized; otherwise false. Implementation and detailed
    // documentation can be found in each event's class.
    public boolean isEmphasized();
}
