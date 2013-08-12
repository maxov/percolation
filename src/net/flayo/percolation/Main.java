package net.flayo.percolation;

import net.flayo.percolation.gen.Generator;
import net.flayo.percolation.display.graphic.GraphicDisplay;
import net.flayo.percolation.display.LatticeDisplay;
import net.flayo.percolation.lattice.move.Move;
import net.flayo.percolation.lattice.Point;

import java.util.ArrayList;
import java.util.Iterator;

/*
    Problem: Calculate the threshold of percolation on a square lattice.
    Solution: Use a monte-carlo algorithm to approximate the percolation threshold to a certain degree.
    Accuracy: So far, Consistently +-0.01 of the best calculations for site percolation. A high-accuracy attempt(large
        size, large iterations) has not been tried.
*/
public class Main {

    // Find the average of a list of doubles
    private static double average(ArrayList<Double> list) {
        double sum = 0;

        for (double elem : list) {
            sum += elem;
        }

        return sum / list.size();
    }

    // The main method(high-level algorithm stuff here)
    public static void main(String[] args) {
        // Initialize a lattice display(A text display can be used just as well)
        LatticeDisplay display = new GraphicDisplay();
        // The list of thresholds, used for averaging out
        ArrayList<Double> thresholds = new ArrayList<Double>();

        // Arbitrary number of times can be used
        for (int times = 0; times <= 20; times++) {
            // A 128x128 lattice is used, size generally doesn't matter
            Generator gen = new Generator(new Point(128, 128));

            boolean percolates = false;
            int count = 0;
            // Keep track of all moves
            ArrayList<Move> moves = new ArrayList<Move>();

            display.displayLattice(gen);

            while (!percolates) {
                count++;

                // Generate a point, add moves
                Point addPoint = gen.gen();
                moves.addAll(gen.moves(addPoint));

                // Apply possible moves
                Iterator<Move> iter = moves.iterator();
                while (iter.hasNext()) {
                    Move move = iter.next();

                    if (move.useful(gen)) {
                        move.apply(gen);
                        iter.remove();
                    }
                }

                // Check for percolation, display lattice
                percolates = gen.percolates();
                display.displayLattice(gen);
            }

            // The threshold
            double threshold = (double) count / gen.size.x / gen.size.y;

            // Display the lattice, add to the thresholds and show some stats
            display.displayLattice(gen);
            thresholds.add(threshold);
            System.out.println(threshold + " threshold-so-far: " + average(thresholds));

        }

        System.out.println("final-percolation-threshold: " + average(thresholds));

    }

}