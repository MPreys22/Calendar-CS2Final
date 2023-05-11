import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarView extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 825;
    private Calendar c;
    private String month;
    private String day;
    private int monthIdx;
    private int dayIdx;
    private String event;

    public CalendarView(Calendar cal) {
        c = cal;
        month = "";
        day = "";
        monthIdx = -1;
        dayIdx = -1;
        event = "";

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
        c.setScreen("Month");

        if(month.equals("")){
            g.drawImage(c.getMainCalendar(), 0, 25, 800, 800, this);
            c.setScreen("Calendar");
        }
        else {
            c.getMonths().get(monthIdx).draw(g);
            if(!day.equals("")) {
                c.getMonths().get(monthIdx).getDays().get(dayIdx).draw(g);
            }
        }
    }

    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

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
            if(c.getScreen().equals("Month")) {
                dayIdx = c.getDayIndex(day);
            }
            if(dayIdx != -1) {
                event = "";
                c.getMonths().get(monthIdx).getDays().get(dayIdx).setEnterIsClicked(true);
                repaint();
            }
        }
        if(keyCode == KeyEvent.VK_BACK_SPACE) {
            c.getMonths().get(monthIdx).getDays().get(dayIdx).backSpace();
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

        event += e.getKeyChar();
        if (keyCode != KeyEvent.VK_BACK_SPACE && keyCode != KeyEvent.VK_SHIFT && keyCode != KeyEvent.VK_ENTER) {
            if (dayIdx != -1 && c.getScreen().equals("Day")) {
                c.getMonths().get(monthIdx).getDays().get(dayIdx).addApts(event);
                repaint();
            }
            event = "";
        }
        // Sequencing of keys, for days, check which keys are typed
    }

    public void mousePressed(MouseEvent e)
    {
        // Make the circle green whenever you press the mouse.
        if(c.getScreen().equals("Calendar")) {
            if (e.getY() > 0 && e.getY() < 204) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("J");
                    month = "f";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("F");
                    month = "f";
                    repaint();
                } else {
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
                } else {
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
                } else {
                    monthIdx = c.getMonthIndex("S");
                    month = "f";
                    repaint();
                }
            } else {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("O");
                    month = "f";
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("N");
                    month = "f";
                    repaint();
                } else {
                    monthIdx = c.getMonthIndex("D");
                    month = "f";
                    repaint();
                }
            }
        }
    }


    public void mouseReleased(MouseEvent e) {// Make the circle blue whenever you let go of the mouse
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) { // this method gets called every time you click and drag
    }
    public void mouseMoved(MouseEvent e) { // this method gets called everytime you move the mouse
    }
}
