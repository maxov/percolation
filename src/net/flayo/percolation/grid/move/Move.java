package net.flayo.percolation.grid.move;

import net.flayo.percolation.grid.Lattice;
import net.flayo.percolation.grid.Point;
import net.flayo.percolation.grid.Site;

import java.util.ArrayList;

/*
    Represents a movement of percolation from one point to another.
*/
public class Move {

    // Start and end points
    public final Point start;
    public final Point end;

    public Move(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Generate all possible percolation moves around a point
    public static ArrayList<Move> vectorMoves(Point point) {
        ArrayList<Move> moves = new ArrayList<Move>();

        moves.add(new Move(point.add(new Point(1, 0)), point));
        moves.add(new Move(point.add(new Point(0, 1)), point));
        moves.add(new Move(point.add(new Point(-1, 0)), point));
        moves.add(new Move(point.add(new Point(0, -1)), point));

        // If this point is at the top of the grid, it automatically percolates
        if (point.y == 0) {
            moves.add(new MoveTop(point));
        }

        return moves;
    }

    // Is this move valid?(Are both the start and end points valid?)
    public boolean valid(Lattice lattice) {
        Point max = lattice.size.subtract(new Point(1, 1));
        return start.inside(max) && end.inside(max);
    }

    // Is this move useful?(Does it abide by the percolation rules?)
    public boolean useful(Lattice lattice) {
        return lattice.perc(start) && lattice.on(end);
    }

    // Apply this move to the lattice
    public void apply(Lattice lattice) {
        lattice.set(end, Site.PERC);
    }

}