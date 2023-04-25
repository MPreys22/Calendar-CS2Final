import java.util.ArrayList;
public class Calendar {
    private int year;
    private ArrayList<Month> calendar;
    private CalendarView window;

    public Calendar() {
        this.window = new CalendarView(this);
        this.year = 2023;
    }

    public int getYear() {
        return this.year;
    }

}
