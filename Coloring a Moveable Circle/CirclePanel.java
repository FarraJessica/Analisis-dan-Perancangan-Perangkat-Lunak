import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {

    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private Color c;
    JButton choose = new JButton("Choose Color");
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------

    public CirclePanel(int width, int height) {
        /* Set coordinates so circle starts in middle */
        x = (width / 2) - (CIRCLE_SIZE / 2);
        y = (height / 2) - (CIRCLE_SIZE / 2);
        c = Color.black;

        /* Need a border layout to get the buttons on the bottom */
        this.setLayout(new BorderLayout());

        /* Create buttons for move the circle with the directs*/

        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");

        /* Create buttons for change colors of the circle */
        JButton pink = new JButton("Pink");
        JButton white = new JButton("White");
        JButton orange = new JButton("Orange");
        JButton magenta = new JButton("Magenta");

        /* Add direct listeners to the buttons */

        left.addActionListener(new MoveListener(-20, 0));
        right.addActionListener(new MoveListener(20, 0));
        up.addActionListener(new MoveListener(0, -20));
        down.addActionListener(new MoveListener(0, 20));

        /* Add colors listeners to the buttons */

        pink.addActionListener(new ColorListener(Color.pink));
        white.addActionListener(new ColorListener(Color.white));
        orange.addActionListener(new ColorListener(Color.orange));
        magenta.addActionListener(new ColorListener(Color.magenta));
        choose.addActionListener(new ColorListener(null));

        /* Change background colors of buttons */

        pink.setBackground(Color.pink);
        white.setBackground(Color.white);
        orange.setBackground(Color.orange);
        magenta.setBackground(Color.magenta);

        /* Need a panel to put the buttons on or they'll be on top of each other. */

        JPanel buttonPanel = new JPanel();
        JPanel colorButtonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        colorButtonPanel.add(pink);
        colorButtonPanel.add(white);
        colorButtonPanel.add(choose);
        colorButtonPanel.add(orange);
        colorButtonPanel.add(magenta);

        /* Add the button panel to the bottom of the main panel */
        this.add(buttonPanel, "South");
        this.add(colorButtonPanel, "North");
    }
    
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
    }
    
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener {

        private int dx;
        private int dy;
        
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
        
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            x += dx;
            y += dy;
            repaint();
        }
    }
    
    //---------------------------------------------------------------
    // Class to listen for button clicks that change the circle's color.
    //---------------------------------------------------------------
    private class ColorListener implements ActionListener {
        
        private Color colors;
        
        public ColorListener(Color colors) {
            this.colors = colors;
        }
        
        public void actionPerformed(ActionEvent e) {
            if(this.colors == null){
                c = JColorChooser.showDialog(choose, "Choose your colors!", c);
            } else {
                c = this.colors;
            }
            repaint();
        }
    }
}