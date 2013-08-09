package net.flayo.percolation.grid;

import java.util.Iterator;

// A position on a grid
public class Vector implements Iterable<Vector> {

    public final int x;
    public final int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Standard operations
    public Vector add(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y);
    }

    public Vector subtract(Vector vector) {
        return add(new Vector(-vector.x, -vector.y));
    }

    public boolean inside(Vector vector) {
        return x >= 0 && x <= vector.x
                && y >= 0 && y <= vector.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Iterate over all containing vectors
    @Override
    public Iterator<Vector> iterator() {
        return new VectorIterator(this);
    }
}