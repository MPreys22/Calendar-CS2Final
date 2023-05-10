import java.awt.*;
import java.util.ArrayList;

public class Day {
    private int numDay;
    private ArrayList<String> allApts;
    private String apts;
    private CalendarView calView;
    private String m;
    private int aptCoord;
    private boolean isClicked;
    private Calendar cal;

    public Day(int numDay, CalendarView window, String month, Calendar c) {
        calView = window;
        this.numDay = numDay;
        apts = "";
        m = month;
        allApts = new ArrayList<String>();
        aptCoord = 150;
        isClicked = false;
        cal = c;
    }

    public int getNumDay() {
        return this.numDay;
    }

    public void setEnterIsClicked(boolean in) {
        isClicked = in;
    }

    public void addApts(String apt) {

            if(apts.length() > 100 || isClicked == true) {
                allApts.add(apts);
                apts = "";
                isClicked = false;
            }
            apts = apts + apt;

    }

    public void setApts(String apt) {
        apts = apt;
        allApts.remove(allApts.size()-1);
        allApts.add(apts);
    }

    public void draw(Graphics g) {
        g.fillRect( 0, 25, 800, 800);
        if(apts != null) {
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.setColor(Color.black);

            g.drawString(m + " " + numDay,325, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 12));

            // Print as im typing but clear once I reach the length thing
            if(!allApts.isEmpty()) {
                for (String s : allApts) {
                    g.drawString(s, 100, aptCoord);
                    aptCoord += 20;
                }
            }
            g.drawString(apts, 100, aptCoord + 15);
            g.setColor(Color.white);
            aptCoord = 150;
            cal.setScreen("Day");
        }
    }

}
