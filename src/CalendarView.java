import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CalendarView extends JFrame implements KeyListener {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private Calendar c;

    public CalendarView(Calendar c) {
        this.c = c;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calendar 2023");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        addKeyListener(this);
    }
    public void paint(Graphics g) {
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

}
