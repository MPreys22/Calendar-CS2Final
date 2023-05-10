import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
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

    // Use parseInt to simplify this!
    public int getDayIndex(String s) {
        if(s.equals("1")) {
            return 0;
        }
        else if(s.equals("2")) {
            return 1;
        }
        else if(s.equals("3")) {
            return 2;
        }
        else if(s.equals("4")) {
            return 3;
        }
        else if(s.equals("5")) {
            return 4;
        }
        else if(s.equals("6")) {
            return 5;
        }
        else if(s.equals("7")) {
            return 6;
        }
        else if(s.equals("8")) {
            return 7;
        }
        else if(s.equals("9")) {
            return 8;
        }
        else if(s.equals("10")) {
            return 9;
        }
        else if(s.equals("11")) {
            return 10;
        }
        else if(s.equals("12")) {
            return 11;
        }
        else if(s.equals("13")) {
            return 12;
        }
        else if(s.equals("14")) {
            return 13;
        }
        else if(s.equals("15")) {
            return 14;
        }
        else if(s.equals("16")) {
            return 15;
        }
        else if(s.equals("17")) {
            return 16;
        }
        else if(s.equals("18")) {
            return 17;
        }
        else if(s.equals("19")) {
            return 18;
        }
        else if(s.equals("20")) {
            return 19;
        }
        else if(s.equals("21")) {
            return 20;
        }
        else if(s.equals("22")) {
            return 21;
        }
        else if(s.equals("23")) {
            return 22;
        }
        else if(s.equals("24")) {
            return 23;
        }
        else if(s.equals("25")) {
            return 24;
        }
        else if(s.equals("26")) {
            return 25;
        }
        else if(s.equals("27")) {
            return 26;
        }
        else if(s.equals("28")) {
            return 27;
        }
        else if(s.equals("29")) {
            return 28;
        }
        else if(s.equals("30")) {
            return 29;
        }
        else if(s.equals("31")){
            return 30;
        }
        else{
            return -1;
        }
    }
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

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Image getMainCalendar() {
        return mainCalendar;
    }

    public static void main(String[] args) {
        Calendar newYear = new Calendar();
    }
}
