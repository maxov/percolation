package net.flayo.percolation.grid;

import java.util.Iterator;
import java.util.LinkedList;

// Utility to iterate over a vector(iterate over all vectors in a vector)
public class VectorIterator implements Iterator<Vector> {

    private LinkedList<Vector> list = new LinkedList<Vector>();

    public VectorIterator(Vector vector) {
        // Populate the vector list
        for(int y = 0; y < vector.y; y++) {
            for(int x = 0; x < vector.x; x++) {
                list.addFirst(new Vector(x, y));
            }
        }
    }

    @Override public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override public Vector next() {
        return list.removeLast();
    }

    @Override public void remove() {

    }
}
