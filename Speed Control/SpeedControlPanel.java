import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SpeedControlPanel extends JPanel
{

    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BALL_SIZE = 50;

    private Circle bouncingBall; /* the object that moves */
    private Timer timer;
    private int moveX, moveY; /* increment to move each time */
    private JPanel sliderPanel;
    private JSlider sliderSpeed;
    private JLabel sliderLabel;
    
    // ---------------------------------------------
    // Sets up the panel, including the timer for the animation
    // ---------------------------------------------
    public SpeedControlPanel()
    {
        timer = new Timer(30, new ReboundListener());

        /* Creat Slider Object*/
        sliderSpeed = new JSlider(JSlider.HORIZONTAL, 0, 200, 30);
        SlideListener listener = new SlideListener();

        sliderSpeed.setMajorTickSpacing(40);
        sliderSpeed.setMinorTickSpacing(10);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintLabels(true);
        sliderSpeed.setAlignmentX(Component.LEFT_ALIGNMENT);
        sliderSpeed.addChangeListener(listener);

        /* Set up a Slider Label */
        sliderLabel = new JLabel("Set Timer Delay");
        sliderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        /* Set up a Slider Panel */
        sliderPanel = new JPanel();
        sliderPanel.add(sliderLabel);
        sliderPanel.add(sliderSpeed);
        this.setLayout(new BorderLayout());
        bouncingBall = new Circle(BALL_SIZE);
        moveX = moveY = 5;

        /* Set up a sliderSpeed object here */
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        this.add(sliderPanel, "South");
        timer.start();
    }
    
    // --------------------
    // Draw the ball
    // --------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        bouncingBall.draw(page);
    }
    
    // ***************************************************
    // An action listener for the timer
    // ***************************************************
    public class ReboundListener implements ActionListener
    {
        // ----------------------------------------------------
        // actionPerformed is called by the timer -- it updates
        // the position of the bouncing ball
        // ----------------------------------------------------
        public void actionPerformed(ActionEvent action)
        {
            int slidePanelHt = sliderPanel.getSize().height;
            bouncingBall.move(moveX, moveY);
            // change direction if ball hits a side
            int x = bouncingBall.getX();
            int y = bouncingBall.getY();
            if (x < 0 || x >= WIDTH - BALL_SIZE) {
                moveX = moveX * -1;
            }
            if (y <= 0 || y >= HEIGHT - slidePanelHt - BALL_SIZE) {
                moveY = moveY * -1;
            }
            repaint();
        }
    }
    
    // *****************************************************
    // A change listener for the sliderSpeed.
    // *****************************************************
    private class SlideListener implements ChangeListener
    {
        // -------------------------------------------------
        // Called when the state of the sliderSpeed has changed;
        // resets the delay on the timer.
        // -------------------------------------------------
        public void stateChanged(ChangeEvent event)
        {
            timer.setDelay(sliderSpeed.sliderValue);
        }
    }
}