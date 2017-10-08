package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import edu.grinnell.sortingvisualizer.events.SortEvent;

public class SortsTest {

    private final static int LENGTH = 20;
    private final static int MAX = 20;

    private ArrayList<Integer> makeUnsortedIntList() {
        ArrayList<Integer> l = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            l.add(generator.nextInt(MAX));
        }
        return l;
    }

    private void testSortedList(ArrayList<Integer> l) {
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i).compareTo(l.get(i + 1)) > 0) {
                fail("Wrong order!");
            }
        }
    }

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

    public void testCommonCases(String sort) {
        // Repeated testing on lists with random integers
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> l = makeUnsortedIntList();
            testSortAlgorithm(sort, l);
            testSortedList(l);
        }
    }

    public void testCornerCases(String sort) {
        // Empty list
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        testSortAlgorithm(sort, l1);

        // List with 1 element
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        testSortAlgorithm(sort, l2);

        // List with 2 elements
        ArrayList<Integer> l3 = new ArrayList<Integer>();
        l2.add(1);
        l3.add(0);
        testSortAlgorithm(sort, l3);
        
        // List in descending order
        ArrayList<Integer> l4 = new ArrayList<Integer>();
        for (int i = 9; i > 0; i--) {
            l4.add(i);
        }
        testSortAlgorithm(sort, l4);
    }
    
    @SuppressWarnings("unchecked")
    public void testEventSort(String sort) {
        ArrayList<Integer> original = makeUnsortedIntList();
        ArrayList<Integer> clone = (ArrayList<Integer>) original.clone();
        List<SortEvent<Integer>> events = testSortAlgorithm(sort, clone);
        Sorts.eventSort(original, events);
        testSortedList(original);
    }

//     @Test
//     public void testMergeSort() {
//     @SuppressWarnings("unchecked")
//     ArrayList<Integer> l1 = (ArrayList<Integer>) l.clone();
//     List<SortEvent<Integer>> events = Sorts.quickSort(l, 0, l.size() - 1);
//     Sorts.eventSort(l1, events);
//     }

     @Test
     public void testSelectionSort() {
     String sort = "selection";
     testCommonCases(sort);
     testCornerCases(sort);
     testEventSort(sort);
     }
     
     @Test
     public void testInsertionSort() {
     String sort = "insertion";
     testCommonCases(sort);
     testCornerCases(sort);
     testEventSort(sort);
     }
     
     @Test
     public void testBubbleSort() {
     String sort = "bubble";
     testCommonCases(sort);
     testCornerCases(sort);
     testEventSort(sort);
     }
     
     @Test
     public void testMergeSort() {
     String sort = "merge";
     testCommonCases(sort);
     testCornerCases(sort);
     testEventSort(sort);
     }
     
     @Test
     public void testQuickSort() {
     String sort = "quick";
     testCommonCases(sort);
     testCornerCases(sort);
     testEventSort(sort);
     }

}
