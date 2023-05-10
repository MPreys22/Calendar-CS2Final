import javax.swing.*;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Graphics;

public class Month {
    private int numDays;
    private Image img;
    private String name;
    private ArrayList<Day> days;
    private CalendarView calView;
    private Calendar cal;

    // TODO make state of days vs months vs calendar
    public Month(String name, int numDays, CalendarView calView, Calendar c) {
        days = new ArrayList<Day>();
        img = new ImageIcon("Resources/Months/" + name + ".png").getImage();
        this.calView = calView;
        cal = c;
        for(int i=0; i<numDays; i++) {
            this.days.add(new Day(i +1, calView, name, c));
        }
    }

    public String getMonth() {
        return this.name;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public Image getMonthImage() {
        return img;
    }

    public void draw (Graphics g) {
        g.drawImage(getMonthImage(), 0, 25, 800, 800, calView);
        cal.setScreen("Month");
    }
}
