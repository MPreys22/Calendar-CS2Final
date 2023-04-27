import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarView extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 825;
    private Calendar c;
    private String month;
    private int day;

    public CalendarView(Calendar c) {
        month = "";
        this.c = c;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calendar 2023");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setVisible(true);

    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        if(month.equals("J")) {
            g.drawString("Gello", 100, 100);
        }
        else {
            g.drawImage(c.getMainCalendar(), 0, 25, 800, 800, this);
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        // Make the circle green whenever you press the mouse.
        if((e.getX() > 0 && e.getX() < 247) && (e.getX() > 0 && e.getX() < 204)) {
            month = "J";
            repaint();
        }

    }


    public void mouseReleased(MouseEvent e)
    {
        // Make the circle blue whenever you let go of the mouse

    }


    public void mouseClicked(MouseEvent e)
    {

    }


    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseDragged(MouseEvent e) { // this method gets called every time you click and drag
        int xMouse = e.getX();
        int yMouse = e.getY();
    }

    public void mouseMoved(MouseEvent e) { // this method gets called everytime you move the mouse

    }
}
