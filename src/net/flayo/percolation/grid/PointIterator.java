package net.flayo.percolation.grid;

import java.util.Iterator;
import java.util.LinkedList;

/*
    Utility to iterate over a point(iterate over all points 'inside' a point).
    Uses a FIFO stack implemented with a LinkedList.
*/
public class PointIterator implements Iterator<Point> {

    // Stores an easy-access stack of points
    private LinkedList<Point> list = new LinkedList<Point>();

    public PointIterator(Point point) {
        // Populate the point list
        for (int y = 0; y < point.y; y++) {
            for (int x = 0; x < point.x; x++) {
                list.addFirst(new Point(x, y));
            }
        }
    }

    /* Iterator methods */

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Point next() {
        return list.removeLast();
    }

    // It is impossible to remove points because points are immutable.
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Points are immutable.");
    }

}
