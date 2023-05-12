import javax.swing.*;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Graphics;

public class Month {
    private Image img;
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

    // Get back all the days to access
    public ArrayList<Day> getDays() {
        return days;
    }

    // Draw specific month then set the screen to month
    public void draw (Graphics g) {
        g.drawImage(img, 0, 25, 800, 800, calView);
        cal.setScreen("Month");
    }
}
