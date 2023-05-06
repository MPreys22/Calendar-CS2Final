import javax.swing.*;
import java.util.ArrayList;
import java.awt.Image;

public class Month {
    private int numDays;
    private Image img;
    private String name;
    private ArrayList<Day> days;

    public Month(String name, int numDays) {
        img = new ImageIcon("Resources/Months/" + name + ".png").getImage();
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

}
