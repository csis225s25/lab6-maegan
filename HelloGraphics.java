import java.awt.*;
import javax.swing.*;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        String s = "Hello, Java Graphics World!";
        int xLoc = getWidth() / 2 - g.getFontMetrics().stringWidth(s) / 2;
        int yLoc = getHeight() / 2 - g.getFontMetrics().getAscent() / 2;

        g.drawString("Hello, Java Graphics World!", xLoc, yLoc);
        g.drawArc(10, 10, 100, 100, 90, 180);
        g.setColor(Color.RED);
        g.drawLine(50, 50, 100, 100);

        int[] xPts = { 10, 20, 30, 40, 50 };
        int[] yPts = { 10, 20, 30, 40, 30 };
        g.setColor(Color.BLACK);
        g.drawPolygon(new Polygon(xPts, yPts, 5));

        g.setColor(Color.GREEN);
        g.drawRect(200, 100, 50, 50);

        g.setColor(Color.BLACK);
        g.fillArc(10, 300, 100, 100, 90, 180);

        g.setColor(Color.RED);
        g.fillOval(200, 300, 50, 50);

        int[] fillXPts = { 400, 300, 130, 200, 150 };
        int[] fillYPts = { 50, 100, 50, 100, 100 };
        g.setColor(Color.BLACK);
        g.fillPolygon(fillXPts, fillYPts, 5);

        g.setColor(Color.GREEN);
        g.fillRect(400, 200, 50, 50);

    }
}

public class HelloGraphics implements Runnable {
    Font f;

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {
        // want to set a new font using named constants in fonts class

        Font f = new Font("Arial", Font.BOLD, 30);

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        panel.setFont(f);
        panel.setBackground(Color.PINK);
        panel.setForeground(Color.BLUE);
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
