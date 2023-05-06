import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarView extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 825;
    private Calendar c;
    private String month;
    private String screen;
    private String day;

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
        this.screen = "month";
        day = "";

    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        screen = "month";

        if(month.equals("J")) {
            g.drawImage(c.getMonths().get(0).getMonthImage(), 0, 25, 800, 800, this);
            if(day.equals("1")) {
                g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.drawString(c.getMonths().get(0).getDays().get(0).getApts(), 100, 100);
                System.out.println("f");
            }
        }
        else if(month.equals("F")) {
            g.drawImage(c.getMonths().get(1).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("M")) {
            g.drawImage(c.getMonths().get(2).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("A")) {
            g.drawImage(c.getMonths().get(3).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("May")) {
            g.drawImage(c.getMonths().get(4).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("Jun")) {
            g.drawImage(c.getMonths().get(5).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("Jul")) {
            g.drawImage(c.getMonths().get(6).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("Au")) {
            g.drawImage(c.getMonths().get(7).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("S")) {
            g.drawImage(c.getMonths().get(8).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("O")) {
            g.drawImage(c.getMonths().get(9).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("N")) {
            g.drawImage(c.getMonths().get(10).getMonthImage(), 0, 25, 800, 800, this);
        }
        else if(month.equals("D")) {
            g.drawImage(c.getMonths().get(11).getMonthImage(), 0, 25, 800, 800, this);
        }
        else {
            g.drawImage(c.getMainCalendar(), 0, 25, 800, 800, this);
            screen = "cal";
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
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE) {
            if(day.equals("")) {
                month = "esc";
                repaint();
            }
            else {
                day = "";
                repaint();
            }
        }
        if(keyCode == KeyEvent.VK_ENTER) {
            repaint();
        }
        if(keyCode == KeyEvent.VK_1) {
            day += "1";
        }
        if(keyCode == KeyEvent.VK_2) {
            day += "2";
        }
        if(keyCode == KeyEvent.VK_3) {
            day += "3";
        }
        if(keyCode == KeyEvent.VK_4) {
            day += "4";
        }
        if(keyCode == KeyEvent.VK_5) {
            day += "5";
        }
        if(keyCode == KeyEvent.VK_6) {
            day += "6";
        }
        if(keyCode == KeyEvent.VK_7) {
            day += "7";
        }
        if(keyCode == KeyEvent.VK_8) {
            day += "8";
        }
        if(keyCode == KeyEvent.VK_9) {
            day += "9";
        }
        if(keyCode == KeyEvent.VK_0) {
            day += "0";
        }
        // Sequencing of keys, for days, check which keys are typed
    }

    public void mousePressed(MouseEvent e)
    {
        // Make the circle green whenever you press the mouse.
        if(screen.equals("cal")) {

            if (e.getY() > 0 && e.getY() < 204) {
                if (e.getX() > 0 && e.getX() < 247) {
                    month = "J";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    month = "F";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    month = "M";
                    repaint();
                }

            } else if (e.getY() > 232 && e.getY() < 412) {
                if (e.getX() > 0 && e.getX() < 247) {
                    month = "A";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    month = "May";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    month = "Jun";
                    repaint();
                }
            } else if (e.getY() > 438 && e.getY() < 618) {
                if (e.getX() > 0 && e.getX() < 247) {
                    month = "Jul";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    month = "Au";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    month = "S";
                    repaint();
                }
            } else if (e.getY() > 643 && e.getY() < 820) {
                if (e.getX() > 0 && e.getX() < 247) {
                    month = "O";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    month = "N";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    month = "D";
                    repaint();
                }
            }
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
