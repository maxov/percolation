package net.flayo.percolation.grid;

// Represents one point on the grid
public enum Switch {
    OFF(0), // Can be off
    ON(1), // Can be on
    PERC(2); // Can be percolating

    // Integer value of this point
    public final int value;

    Switch(int value) {
        this.value = value;
    }

    // Testing the state of this point
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