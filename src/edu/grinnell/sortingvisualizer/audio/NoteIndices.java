package edu.grinnell.sortingvisualizer.audio;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {

    private ArrayList<Integer> indices;
    private ArrayList<Integer> highlightedNotes;

    /**
     * @param n
     *            the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        indices = new ArrayList<Integer>();
        highlightedNotes = new ArrayList<Integer>();
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object of
     * the given size. The collection is also shuffled to provide an initial
     * starting point for the sorting process.
     * 
     * @param n
     *            the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        indices = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);
    }

    /** @return the indices of this NoteIndices object */
    public ArrayList<Integer> getNotes() {
        return indices;
    }

    /**
     * Highlights the given index of the note array
     * 
     * @param index
     *            the index to highlight
     */
    public void highlightNote(int index) {
        highlightedNotes.add(index);
    }

    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
        return highlightedNotes.contains(index);
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        highlightedNotes.clear();
    }
}
