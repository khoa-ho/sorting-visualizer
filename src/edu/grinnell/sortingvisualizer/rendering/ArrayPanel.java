package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

/***
 * This class implements the portion of the SortingVisualizer graphical user
 * interface that renders the note indices to the screen.
 * 
 * @author zhanghon hokhoa
 *
 */
@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;

    /**
     * Constructs a new ArrayPanel that renders the given note indices to the
     * screen
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

    /***
     * Sets a graphics object's current color to a specified color, if the given
     * integer is a highlighted index in this ArrayPanel object's notes' indices. If
     * the given integer is not a highlighted index, then set the given graphics
     * object's current color to other colors.
     * 
     * @param g
     *            a Graphics object
     * @param barIndex
     *            an index of the ArrayPanel's notes' indices array list
     */
    private void setBarColor(Graphics g, int barIndex) {
        ArrayList<Integer> indices = notes.getNotes();
        int step = (255 - 12) / (notes.getNotes().size() - 1);
        if (notes.isHighlighted(barIndex)) {
            g.setColor(new Color(139, 63, 39));
        } else {
            g.setColor(new Color(35, 139, 12 + indices.get(barIndex) * step));
        }
    }

    /***
     * Renders the current ArrayPanel's notes' indices to g. Each index is rendered
     * as a vertical bar. The larger the index, the higher the bar. All the bars
     * have the same width.
     * 
     * @param g
     *            a Graphics object
     */
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

    /***
     * Gets an ArrayPanel object's notes field
     * 
     * @return the notes of this ArrayPanel object
     */
    public NoteIndices getNoteIndices() {
        return notes;
    }
}
