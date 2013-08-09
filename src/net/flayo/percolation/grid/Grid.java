package net.flayo.percolation.grid;

import java.util.ArrayList;

// A grid of 0s or 1s
public class Grid {
	
	public final Vector size;
	public final Switch[][] data;
	
	public Grid(Switch[][] grid) {
        size = new Vector(grid.length, grid[0].length);
		data = grid;
	}

    public Grid(Vector size) {
        this(new Switch[size.x][size.y]);
        // Initialize the whole grid to be 0ff
        for(Vector vector : this.size) {
            set(vector, Switch.OFF);
        }
    }

	public void set(Vector vector, Switch val) {
		data[vector.x][vector.y] = val;
	}
	
	public Switch at(Vector vector) {
		return data[vector.x][vector.y];
	}

    // Generate valid moves around a vector
    public ArrayList<Move> moves(Vector vector) {
        ArrayList<Move> moves = new ArrayList<Move>();

        for(Move move : Move.vectorMoves(vector)) {
            if(move.valid(this)) {
                moves.add(move);
            }
        }

        return moves;
    }

    // Does this grid percolates?
    public boolean percolates() {
        int sizeY = size.y - 1;

        for(int x = 0; x < size.x; x++) {
            if(perc(new Vector(x, sizeY))) {
                return true;
            }
        }

        return false;
    }

    // Quick testing of state for a point
    public boolean off(Vector vector) {
        return at(vector).off();
    }

    public boolean on(Vector vector) {
        return at(vector).on();
    }

    public boolean perc(Vector vector) {
        return at(vector).perc();
    }

}
