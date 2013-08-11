package net.flayo.percolation.display.graphic;

import net.flayo.percolation.grid.Lattice;
import net.flayo.percolation.grid.Point;

import javax.swing.*;
import java.awt.*;

/*
    The actual panel that displays a lattice ful of sites.
*/
public class DisplayPanel extends JPanel {

    // Colors used in the display
    private static final Color PERC_COLOR = new Color(19, 111, 77);
    private static final Color ON_COLOR = new Color(153, 153, 153);
    private static final Color OFF_COLOR = new Color(205, 205, 205);

    // Paint a lattice
    @Override public void paintComponent(Graphics g) {

        Lattice lattice = GraphicDisplay.lattice;
        Point size = lattice.size;
        // The x and y length of one square representing a site
        double squareX = getWidth() / (double) (size.x);
        double squareY = getHeight() / (double) (size.y);

        // Display all sites
        for (Point point : size) {
            // The x and y of the top left of this site
            int x = (int) (squareX * point.x);
            int y = (int) (squareY * point.y);

            if (lattice.perc(point)) {
                g.setColor(PERC_COLOR);
            } else if (lattice.on(point)) {
                g.setColor(ON_COLOR);
            } else {
                g.setColor(OFF_COLOR);
            }

            // Render the site
            g.fillRect(x, y, (int) squareX, (int) squareY);
        }
    }
}