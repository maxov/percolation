package net.flayo.percolation.grid;

// If a vector is on the top, make this top move
public class MoveTop extends Move {

    public MoveTop(Vector start) {
        super(start, start);
    }

    // Is this move valid?
    @Override public boolean valid(Grid grid) {
        return super.valid(grid) && start.y == 0;
    }

    // Is this move useful?
    @Override public boolean useful(Grid grid) {
        return grid.on(start);
    }

}
