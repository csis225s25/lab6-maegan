import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {

    String toDisplay;
    String msg = "Mouse Press Count:";
    int counter = 0;
    JPanel panel;


    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("MousePressCounter");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toDisplay = msg + counter++;
        // construct an anonymous class that extends JPanel,
        // for which we override the paintComponent method
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);

                FontMetrics fm = g.getFontMetrics();

                int stringWidth = fm.stringWidth(toDisplay);
                int stringAscent = fm.getAscent();

                int xStart = getWidth() / 2 - stringWidth / 2;
                int yStart = getHeight() / 2 + stringAscent / 2;

                g.drawString(toDisplay, xStart, yStart);
            }
        };
        JButton resetButton = new JButton("Reset");
        
        panel.add(resetButton);
        frame.add(panel);
       
        resetButton.addActionListener(this);
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        panel.addMouseWheelListener(this);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter = 0;
        toDisplay = msg + counter++;
        panel.repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        // System.out.println("mouseClicked: " + e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        toDisplay = msg + counter++;
        panel.repaint();
        // System.out.println("mousePressed: " + e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.println("mouseReleased: " + e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("mouseEntered: " + e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("mouseExited: " + e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // System.out.println("mouseDragged: " + e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println("mouseMoved: " + e);
    }
    /*
     * @Override
     * public void mouseWheelMoved(MouseWheelEvent e) {
     * //System.out.println("mouseWheelMoved: " + e);
     * }
     */

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
    }
}
