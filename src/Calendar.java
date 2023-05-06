import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Calendar {
    private int year;
    private ArrayList<Month> calendar;
    private String[] months;
    private CalendarView window;
    private Image mainCalendar;

    public Calendar() {
        this.year = 2023;
        calendar = new ArrayList<>();
        months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        mainCalendar = new ImageIcon("Resources/FullYear.png").getImage();
        this.window = new CalendarView(this);
        for(int i=0; i<12; i++) {
            if(oneEquals(i, 0, 2, 4, 6, 7, 9, 11)) {
                calendar.add(new Month(months[i], 31));
            }
            else if (i == 1){
                calendar.add(new Month(months[i], 28));
            }
            else {
                calendar.add(new Month(months[i], 30));
            }
        }
    }

    public boolean oneEquals(int start, int m0, int m1, int m2, int m3, int m4, int m5, int m6){
        if(start == m0 || start == m1 || start == m2 || start == m3 || start == m4 || start == m5 || start == m6) {
            return true;
        }
        return false;
    }

    public ArrayList<Month> getMonths() {
        return calendar;
    }
    public int getYear() {
        return this.year;
    }

    public Image getMainCalendar() {
        return mainCalendar;
    }

    public static void main(String[] args) {
        Calendar newYear = new Calendar();
    }
}
