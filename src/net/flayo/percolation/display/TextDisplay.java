package net.flayo.percolation.display;

import net.flayo.percolation.grid.Lattice;
import net.flayo.percolation.grid.Point;

/*
    A simple lattice text display that uses the out stream(useful for debugging).
*/
public class TextDisplay implements LatticeDisplay {

    // Characters used in the display
    private static final char PERC_CHAR = '@';
    private static final char ON_CHAR = '0';
    private static final char OFF_CHAR = '.';

    @Override
    public void displayLattice(Lattice lattice) {

        for (int y = 0; y < lattice.size.y; y++) {
            for (int x = 0; x < lattice.size.x; x++) {
                Point point = new Point(x, y);

                if (lattice.perc(point)) {
                    System.out.print(PERC_CHAR + " ");
                } else if (lattice.on(point)) {
                    System.out.print(ON_CHAR + " ");
                } else {
                    System.out.print(OFF_CHAR + " ");
                }
            }
            System.out.println();
        }

        System.out.println("============\n============");
    }

}
