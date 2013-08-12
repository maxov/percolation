package net.flayo.percolation.lattice.move;

import net.flayo.percolation.lattice.Lattice;
import net.flayo.percolation.lattice.Point;

/*
    A rule for automatically making top points percolate.
*/
public class MoveTop extends Move {

    public MoveTop(Point start) {
        super(start, start);
    }

    // Is this move valid?
    @Override
    public boolean valid(Lattice lattice) {
        return super.valid(lattice) && start.y == 0;
    }

    // Is this move useful?
    @Override
    public boolean useful(Lattice lattice) {
        return lattice.on(start);
    }

}
