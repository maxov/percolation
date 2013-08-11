package net.flayo.percolation.grid;

import net.flayo.percolation.grid.move.Move;

import java.util.ArrayList;

/*
    A percolation field, full of off, ons, and percs.
*/
public class Lattice {

    public final Point size;
    public final Site[][] data;

    public Lattice(Site[][] grid) {
        size = new Point(grid.length, grid[0].length);
        data = grid;
    }

    public Lattice(Point size) {
        this(new Site[size.x][size.y]);
        // Initialize the whole grid to be 0ff
        for (Point point : this.size) {
            set(point, Site.OFF);
        }
    }

    /* Get/set a site using points */

    public void set(Point point, Site val) {
        data[point.x][point.y] = val;
    }

    public Site at(Point point) {
        return data[point.x][point.y];
    }

    // Generate valid moves around a point
    public ArrayList<Move> moves(Point point) {
        ArrayList<Move> moves = new ArrayList<Move>();

        for (Move move : Move.vectorMoves(point)) {
            if (move.valid(this)) {
                moves.add(move);
            }
        }

        return moves;
    }

    public boolean percolates() {
        int sizeY = size.y - 1;

        // Percolation happens if any points in the bottom row percolate
        for (int x = 0; x < size.x; x++) {
            if (perc(new Point(x, sizeY))) {
                return true;
            }
        }

        return false;
    }

    /* Quick testing of site state for a point */

    public boolean off(Point point) {
        return at(point).off();
    }

    public boolean on(Point point) {
        return at(point).on();
    }

    public boolean perc(Point point) {
        return at(point).perc();
    }

}
