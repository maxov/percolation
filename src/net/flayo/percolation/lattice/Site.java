package net.flayo.percolation.lattice;

/*
    Represents one point on the lattice.
*/
public enum Site {
    OFF(0), // Can be off
    ON(1), // Can be on
    PERC(2); // Can be percolating

    // Integer value of this site
    private final int value;

    Site(int value) {
        this.value = value;
    }

    /* Quick state testing of this site */

    public boolean off() {
        return this.value == 0;
    }

    public boolean on() {
        return this.value == 1;
    }

    public boolean perc() {
        return this.value == 2;
    }

}