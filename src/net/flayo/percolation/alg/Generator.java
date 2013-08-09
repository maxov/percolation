package net.flayo.percolation.alg;

import net.flayo.percolation.grid.Grid;
import net.flayo.percolation.grid.Switch;
import net.flayo.percolation.grid.Vector;

import java.util.Random;

public class Generator extends Grid {

    public Generator(Vector size) {
        super(size);
    }

    public Vector gen() {
        Random rand = new Random();
        Vector point;

        do {
            int x = rand.nextInt(size.x);
            int y = rand.nextInt(size.y);
            point = new Vector(x, y);
        } while (on(point) || perc(point));

        set(point, Switch.ON);
        return point;
    }

}
