package net.flayo.percolation.display;

import net.flayo.percolation.grid.Grid;
import net.flayo.percolation.grid.Vector;

import javax.swing.*;
import java.awt.*;

// A way to display grid graphically
public class GraphicDisplay extends JFrame implements GridDisplay {

	private static final long serialVersionUID = -2454867989388222121L;

	private JPanel panel = new DisplayPanel();

    private static Grid grid = new Grid(new Vector(1, 1));

	public GraphicDisplay() {

		setTitle("Percolation");
        setSize(960, 960);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		add(panel);
	}

	public void displayGrid(Grid grid) {
        this.grid = grid;
		panel.repaint();
	}

	static class DisplayPanel extends JPanel {

		private static final long serialVersionUID = 4938999631236251213L;

        public DisplayPanel() {
            setSize(960, 960);
        }

		@Override public void paintComponent(Graphics g) {

            Vector size = grid.size;
            double squareX = getWidth() / (double) (size.x);
            double squareY = getHeight() / (double) (size.y);

            for(Vector vector : size) {
                int x = (int) (squareX * vector.x);
                int y = (int) (squareY * vector.y);
                if(grid.perc(vector)) {
                    g.setColor(new Color(19, 111, 77));
                } else if(grid.on(vector)) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    g.setColor(new Color(205, 205, 205));
                }
                g.fillRect(x, y, (int) squareX, (int) squareY);
            }

		}
	}

}