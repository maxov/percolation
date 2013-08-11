package net.flayo.percolation.grid.move;

import net.flayo.percolation.grid.Lattice;
import net.flayo.percolation.grid.Point;
import net.flayo.percolation.grid.move.Move;

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
