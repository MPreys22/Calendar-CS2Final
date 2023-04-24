import java.util.ArrayList;

public class Month {
    private int numDays;
    private String name;
    private ArrayList<Day> days;

    public Month(String name, int numDays) {

    }

    public String getMonth() {
        return this.name;
    }

    public int getDays() {
        return numDays;
    }

}
