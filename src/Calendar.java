import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
import static java.lang.Integer.parseInt;

public class Calendar {
    private int year;
    private ArrayList<Month> calendar;
    private String[] months;
    private CalendarView window;
    private Image mainCalendar;
    private String screen;

    public Calendar() {
        year = 2023;
        calendar = new ArrayList<>();
        months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        mainCalendar = new ImageIcon("Resources/FullYear.png").getImage();
        this.window = new CalendarView(this);
        screen = "Calendar";
        for(int i=0; i<12; i++) {
            if(oneEquals(i, 0, 2, 4, 6, 7, 9, 11)) {
                calendar.add(new Month(months[i], 31, this.window, this));
            }
            else if (i == 1){
                calendar.add(new Month(months[i], 28, this.window, this));
            }
            else {
                calendar.add(new Month(months[i], 30, this.window, this));
            }
        }
    }

    // Used for all the months for 31 days, (Majority)
    public boolean oneEquals(int start, int m0, int m1, int m2, int m3, int m4, int m5, int m6){
        if(start == m0 || start == m1 || start == m2 || start == m3 || start == m4 || start == m5 || start == m6) {
            return true;
        }
        return false;
    }

    // Allows access to all months
    public ArrayList<Month> getMonths() {
        return calendar;
    }

    // Depending on the day inputted, find if there is a day equal to it then return that days index
    // If there is no day, return -1
    public int getDayIndex(String s) {
        int input = parseInt(s);
        for(int i=1; i<= 31; i++) {
            if(i == input) {
                return i-1;
            }
        }
        return -1;
    }
    // Depending on the month string inputted, give back an index which correlates to each month
    public int getMonthIndex(String s) {
        if(s.equals("J")) {
            return 0;
        }
        else if(s.equals("F")) {
            return 1;
        }
        else if(s.equals("M")) {
            return 2;
        }
        else if(s.equals("A")) {
            return 3;
        }
        else if(s.equals("May")) {
            return 4;
        }
        else if(s.equals("Jun")) {
            return 5;
        }
        else if(s.equals("Jul")) {
            return 6;
        }
        else if(s.equals("Au")) {
            return 7;
        }
        else if(s.equals("S")) {
            return 8;
        }
        else if(s.equals("O")) {
            return 9;
        }
        else if(s.equals("N")) {
            return 10;
        }
        else {
            return 11;
        }
    }

    // Return the screen which the program is on for making decisions about certain key inputs
    public String getScreen() {
        return screen;
    }

    // Allows to set screen from any class that has a calendar variable
    public void setScreen(String screen) {
        this.screen = screen;
    }

    // Just returns the mainCalendar image
    public Image getMainCalendar() {
        return mainCalendar;
    }

    // Creates a new Calendar which makes a new window
    public static void main(String[] args) {
        Calendar newYear = new Calendar();
    }
}
