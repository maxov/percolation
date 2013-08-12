package net.flayo.percolation.display.graphic;

import net.flayo.percolation.display.LatticeDisplay;
import net.flayo.percolation.lattice.*;
import net.flayo.percolation.lattice.Point;

import javax.swing.*;

/*
    Display a lattice graphically(pretty cool).
*/
public class GraphicDisplay extends JFrame implements LatticeDisplay {

    private final JPanel panel = new DisplayPanel();
    // The lattice is stored statically for a DisplayPanel to use
    public static Lattice lattice = new Lattice(new Point(1, 1));

    public GraphicDisplay() {
        // Initialize this display
        setTitle("Percolation");
        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(panel);
    }

    // The method to display a lattice
    public void displayLattice(Lattice lattice) {
        GraphicDisplay.lattice = lattice;
        panel.repaint();
    }

}