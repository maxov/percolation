package net.flayo.percolation.display;

import net.flayo.percolation.grid.Grid;
import net.flayo.percolation.grid.Switch;
import net.flayo.percolation.grid.Vector;

// A simple text display with System.out.println
public class TextDisplay implements GridDisplay {

	@Override public void displayGrid(Grid grid) {
		StringBuffer line = new StringBuffer(grid.size.x);

		for(int y = 0; y < grid.size.y; y++) {
            for(int x = 0; x < grid.size.x; x++) {
                Vector vector = new Vector(x, y);
                if(grid.perc(vector)) {
                    System.out.print("@ ");
                } else if(grid.on(vector)) {
                    System.out.print("0 ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println("============\n============");
	}

}
