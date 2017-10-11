package edu.grinnell.sortingvisualizer;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;
import edu.grinnell.sortingvisualizer.rendering.ArrayPanel;
import edu.grinnell.sortingvisualizer.rendering.ControlPanel;

/***
 * CSC207 The Sounds of Sorting
 *
 * This class is a driver for both a visualizer and audibilizer for the various sorting algorithms.
 * 
 * @author zhanghon hokhoa
 *
 */

public class SortingVisualizer {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    /***
     * This is the main driver of the Sorting Visualizer program.
     * @param args, command-line arguments (not needed in our case)
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        NoteIndices notes = new NoteIndices(0);

        ArrayPanel arrayPanel = new ArrayPanel(notes, WIDTH, HEIGHT);
        ControlPanel controlPanel = new ControlPanel(notes, arrayPanel);

        frame.setTitle("Sorting Visualizer");
        frame.add(controlPanel, BorderLayout.PAGE_END);
        frame.add(arrayPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
