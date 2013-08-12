package net.flayo.percolation.lattice;

import java.util.Iterator;

/*
    Represents an immutable position on a lattice.
    Points are generally decoupled from a lattice
*/
public class Point implements Iterable<Point> {

    // The components of this point
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* Immutable vector operations */

    public Point add(Point point) {
        return new Point(this.x + point.x, this.y + point.y);
    }

    public Point subtract(Point point) {
        return add(new Point(-point.x, -point.y));
    }

    // 'Inside' is useful when working with a lattice, checking if a point is valid within a lattice.
    public boolean inside(Point point) {
        return x >= 0 && x <= point.x
                && y >= 0 && y <= point.y;
    }

    // Provides a compact string representation of a point(useful for debugging).
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Provides the ability to iterate over all points 'inside' this point.
    @Override
    public Iterator<Point> iterator() {
        return new PointIterator(this);
    }

}