package net.flayo.percolation;

import net.flayo.percolation.alg.Generator;
import net.flayo.percolation.display.GraphicDisplay;
import net.flayo.percolation.display.GridDisplay;
import net.flayo.percolation.grid.Move;
import net.flayo.percolation.grid.Vector;

import java.util.ArrayList;
import java.util.Iterator;

// Problem: what percentage, on average, is needed for percolation to occur on a 48x48 grid?
// Bonus: Display this percentage, and its computation, in a meaningful way.
public class Main {

    public static void main(String[] args) {
        GridDisplay display = new GraphicDisplay();

        for (int times = 0; times <= 20; times++) {
            Generator gen = new Generator(new Vector(128, 128));

            boolean percolates = false;
            int count = 0;
            ArrayList<Move> moves = new ArrayList<Move>();

            display.displayGrid(gen);

            while (!percolates) {
                count++;
                Vector addVector = gen.gen();

                moves.addAll(gen.moves(addVector));

                Iterator<Move> iter = moves.iterator();
                while (iter.hasNext()) {
                    Move move = iter.next();
                    if (move.useful(gen)) {
                        move.apply(gen);
                        iter.remove();
                    }
                }

                percolates = gen.percolates();
                display.displayGrid(gen);
            }


            display.displayGrid(gen);
            System.out.println((double) count / gen.size.x / gen.size.y);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}