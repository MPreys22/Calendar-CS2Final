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
    private int monthIdx;
    private int dayIdx;
    private String event;

    public CalendarView(Calendar cal) {
        month = "";
        c = cal;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calendar 2023");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setVisible(true);
        screen = "month";
        day = "";
        monthIdx = -1;
        dayIdx = -1;
        event = "";

    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        screen = "month";

        if(month.equals("")){
            g.drawImage(c.getMainCalendar(), 0, 25, 800, 800, this);
            screen = "cal";
        }
        else {
            c.getMonths().get(monthIdx).draw(g);
            if(!day.equals("")) {
                c.getMonths().get(monthIdx).getDays().get(dayIdx).draw(g);
            }
        }


    }

    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        event += e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE) {
            if(day.equals("")) {
                month = "";
                repaint();
            }
            else {
                day = "";
                repaint();
            }
        }
        if(keyCode == KeyEvent.VK_ENTER) {
            dayIdx = c.getDayIndex(day);
            if(dayIdx != -1) {
                c.getMonths().get(monthIdx).getDays().get(dayIdx).setApts(event);
                repaint();
            }
            event = "";
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
                    monthIdx = c.getMonthIndex("J");
                    month = "f";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("F");
                    month = "f";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    monthIdx = c.getMonthIndex("M");
                    month = "f";
                    repaint();
                }

            } else if (e.getY() > 232 && e.getY() < 412) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("A");
                    month = "f";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("May");
                    month = "f";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    monthIdx = c.getMonthIndex("Jun");
                    month = "f";
                    repaint();
                }
            } else if (e.getY() > 438 && e.getY() < 618) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("Jul");
                    month = "f";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("Au");
                    month = "f";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    monthIdx = c.getMonthIndex("S");
                    month = "f";
                    repaint();
                }
            } else if (e.getY() > 643 && e.getY() < 820) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("O");
                    month = "f";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("N");
                    month = "f";
                    repaint();
                } else if (e.getX() > 550 && e.getX() < 794) {
                    monthIdx = c.getMonthIndex("D");
                    month = "f";
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
