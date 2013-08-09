package net.flayo.percolation.grid;

import java.util.ArrayList;

// Represents a vector change
public class Move {

    public final Vector start;
    public final Vector end;

    public Move(Vector start, Vector end) {
        this.start = start;
        this.end = end;
    }

    // Generate moves for a point
    public static ArrayList<Move> vectorMoves(Vector vector) {
        ArrayList<Move> moves = new ArrayList<Move>();

        moves.add(new Move(vector.add(new Vector(1, 0)), vector));
        moves.add(new Move(vector.add(new Vector(0, 1)), vector));
        moves.add(new Move(vector.add(new Vector(-1, 0)), vector));
        moves.add(new Move(vector.add(new Vector(0, -1)), vector));

        // If this vector is at the top of the grid, it automatically percolates
        if(vector.y == 0) {
            moves.add(new MoveTop(vector));
        }

        return moves;
    }

    // Is this move valid?
    public boolean valid(Grid grid) {
        Vector max = grid.size.subtract(new Vector(1, 1));
        return start.inside(max) && end.inside(max);
    }

    // Is this move useful?
    public boolean useful(Grid grid) {
        return grid.perc(start) && grid.on(end);
    }

    // Apply this move to the grid
    public void apply(Grid grid) {
        grid.set(end, Switch.PERC);
    }

}