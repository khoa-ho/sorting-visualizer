package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import edu.grinnell.sortingvisualizer.events.SortEvent;

/***
 * Tests the sorting algorithms and eventSort
 * 
 * @author zhanghon hokhoa
 *
 */
public class SortsTest {

    private final static int LENGTH = 20;
    private final static int MAX = 20;

    /***
     * Makes an unsorted integer array list of 20 random integers between 0
     * (inclusive) and MAX (exclusive)
     * 
     * @return l, an array list of 20 elements
     */
    private ArrayList<Integer> makeUnsortedIntList() {
        ArrayList<Integer> l = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            l.add(generator.nextInt(MAX));
        }
        return l;
    }

    /***
     * Tests if an array list is sorted
     * 
     * @param l
     *            an array list
     * @return true if l is sorted; otherwise returns false
     */
    private boolean isListSorted(ArrayList<Integer> l) {
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i).compareTo(l.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    /***
     * Tests the given sort algorithm on l
     * 
     * @param sort
     *            the name of a sorting algorithm
     * @param l
     *            an array list
     * @return a List of SortEvent objects logging all the important events of the
     *         sorting algorithm
     */
    private static List<SortEvent<Integer>> testSortAlgorithm(String sort, ArrayList<Integer> l) {
        switch (sort) {
        case "selection":
            return Sorts.selectionSort(l);
        case "insertion":
            return Sorts.insertionSort(l);
        case "bubble":
            return Sorts.bubbleSort(l);
        case "merge":
            return Sorts.mergeSort(l, 0, l.size());
        case "quick":
            return Sorts.quickSort(l, 0, l.size() - 1);
        default:
            throw new IllegalArgumentException("generateEvents");
        }
    }

    // Tests on a list with random integers in random orders
    public void testCommonCase(String sort) {
        ArrayList<Integer> l = makeUnsortedIntList();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l, events);
        assertEquals(l, clone);
    }

    // Test on an empty list
    public void testCornerCase1(String sort) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l1.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l1, events);
        assertEquals(l1, clone);
    }

    // Test on lists with 1 element
    public void testCornerCase2(String sort) {
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l2.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l2, events);
        assertEquals(l2, clone);
    }

    // Test on lists with 2 elements
    public void testCornerCase3(String sort) {
        ArrayList<Integer> l3 = new ArrayList<Integer>();
        l3.add(1);
        l3.add(0);
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l3.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l3, events);
        assertEquals(l3, clone);
    }

    // Tests on a list in descending order
    public void testCornerCase4(String sort) {
        ArrayList<Integer> l4 = new ArrayList<Integer>();
        for (int i = 9; i > 0; i--) {
            l4.add(i);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l4.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l4, events);
        assertEquals(l4, clone);
    }

    // Tests on an already-sorted list
    public void testCornerCase5(String sort) {
        ArrayList<Integer> l5 = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            l5.add(i);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l5.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l5, events);
        assertEquals(l5, clone);
    }

    // Tests on a list in which all elements have the same value
    public void testCornerCase6(String sort) {
        ArrayList<Integer> l6 = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            l6.add(0);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clone = (ArrayList<Integer>) l6.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        if (isListSorted(clone) == false) {
            fail("Not Sorted");
        }
        Sorts.eventSort(l6, events);
        assertEquals(l6, clone);
    }

    // Tests all the above corner cases for a sorting algorithm
    public void testCornerCases(String sort) {
        testCornerCase1(sort);
        testCornerCase2(sort);
        testCornerCase3(sort);
        testCornerCase4(sort);
        testCornerCase5(sort);
        testCornerCase6(sort);
    }

    @Test
    public void testSelectionSort() {
        String sort = "selection";
        testCommonCase(sort);
        testCornerCases(sort);
    }

    @Test
    public void testInsertionSort() {
        String sort = "insertion";
        testCommonCase(sort);
        testCornerCases(sort);
    }

    @Test
    public void testBubbleSort() {
        String sort = "bubble";
        testCommonCase(sort);
        testCornerCases(sort);
    }

    @Test
    public void testMergeSort() {
        String sort = "merge";
        testCommonCase(sort);
        testCornerCases(sort);
    }

    @Test
    public void testQuickSort() {
        String sort = "quick";
        testCommonCase(sort);
        testCornerCases(sort);
    }
}
