import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarView extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 825;
    private Calendar c;
    private boolean month;
    private String day;
    private int monthIdx;
    private int dayIdx;
    private String event;

    public CalendarView(Calendar cal) {
        c = cal;
        month = false;
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
        // Draw over the original calendar page
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        c.setScreen("Month");

        if(month == false){
            // Original calendar screen with all months
            g.drawImage(c.getMainCalendar(), 0, 25, 800, 800, this);
            c.setScreen("Calendar");
        }
        else {
            // If month is true meaning one was clicked, draw the image of that month
            c.getMonths().get(monthIdx).draw(g);
            if(!day.equals("")) {
                // Same thing as the month for the day, is not empty and has a value, draw that day
                c.getMonths().get(monthIdx).getDays().get(dayIdx).draw(g);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // Get the integer value of key pressed
        int keyCode = e.getKeyCode();

        // Escape will result in day or month being set to empty/false and repainting making
        // the program go back a screen
        if(keyCode == KeyEvent.VK_ESCAPE) {
            if(day.equals("")) {
                month = false;
                repaint();
            }
            else {
                day = "";
                repaint();
            }
        }
        // Depending on which screen the program is on, the enter key will either help
        // get the day or result in a line break
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
        // Delete last character drawn
        if(keyCode == KeyEvent.VK_BACK_SPACE) {
            c.getMonths().get(monthIdx).getDays().get(dayIdx).backSpace();
            repaint();
        }
        // For every number pressed, concat to the day string until enter is pressed to get that day
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

        // Event is the string being typed and if on the day screen and a valid day, the specific day will
        // draw what is inputted
        event += e.getKeyChar();
        if (keyCode != KeyEvent.VK_BACK_SPACE && keyCode != KeyEvent.VK_SHIFT && keyCode != KeyEvent.VK_ENTER) {
            if (dayIdx != -1 && c.getScreen().equals("Day")) {
                c.getMonths().get(monthIdx).getDays().get(dayIdx).addApts(event);
                repaint();
            }
            event = "";
        }
    }

    public void mousePressed(MouseEvent e)
    {
        // Make sure the screen is the calendar and if so, check which coordinates for
        // choosing and setting the month variable to true for checks like escape
        if(c.getScreen().equals("Calendar")) {
            if (e.getY() > 0 && e.getY() < 204) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("J");
                    month = true;
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("F");
                    month = true;
                    repaint();
                } else {
                    monthIdx = c.getMonthIndex("M");
                    month = true;
                    repaint();
                }
            } else if (e.getY() > 232 && e.getY() < 412) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("A");
                    month = true;
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("May");
                    month = true;
                    repaint();
                } else {
                    monthIdx = c.getMonthIndex("Jun");
                    month = true;
                    repaint();
                }
            } else if (e.getY() > 438 && e.getY() < 618) {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("Jul");
                    month = true;
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("Au");
                    month = true;
                    repaint();
                } else {
                    monthIdx = c.getMonthIndex("S");
                    month = true;
                    repaint();
                }
            } else {
                if (e.getX() > 0 && e.getX() < 247) {
                    monthIdx = c.getMonthIndex("O");
                    month = true;
                    repaint();
                } else if (e.getX() > 273 && e.getX() < 521) {
                    monthIdx = c.getMonthIndex("N");
                    month = true;
                    repaint();
                } else {
                    monthIdx = c.getMonthIndex("D");
                    month = true;
                    repaint();
                }
            }
        }
    }

    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
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
