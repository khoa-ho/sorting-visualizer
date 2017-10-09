package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;

    /**
     * Constructs a new ArrayPanel that renders the given note indices to the
     * screen.
     * 
     * @param notes
     *            the indices to render
     * @param width
     *            the width of the panel
     * @param height
     *            the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    private void setBarColor(Graphics g, int barIndex) {
        ArrayList<Integer> indices = notes.getNotes();
        int step = (255 - 12) / notes.getNotes().size();
        if (notes.isHighlighted(barIndex)) {
            g.setColor(new Color(139, 63, 39));
        } else {
            g.setColor(new Color(35, 139, 12 + indices.get(barIndex) * step));
        }
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());

        ArrayList<Integer> indices = notes.getNotes();
        int scaleFactor = this.getHeight() / (Collections.max(indices) + 1);
        int barWidth = this.getWidth() / indices.size();

        for (int i = 0; i < indices.size(); i++) {
            setBarColor(g, i);
            g.fillRect(i * barWidth, this.getHeight() - (indices.get(i) + 1) * scaleFactor,
                    barWidth, this.getHeight());
        }
        notes.clearAllHighlighted();
    }

    public NoteIndices getNoteIndices() {
        return notes;
    }
}
