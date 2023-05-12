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

    public void setEnterIsClicked(boolean in) {
        isClicked = in;
    }

    // If the length of the string is over 100 or isClicked is set to true, then line break and add
    // to the allApts arrayList to save and print later
    // Otherwise, just add the input to the full string
    public void addApts(String apt) {
            if(apts.length() > 100 || isClicked == true) {
                allApts.add(apts);
                apts = "";
                isClicked = false;
            }
            apts = apts + apt;

    }

    // As long as the length does not equal to zero, get rid of the last character
    // of the string on the current line
    public void backSpace() {
        if(apts.length() != 0) {
            apts = apts.substring(0, apts.length() - 1);
        }
    }

    public void draw(Graphics g) {
        g.fillRect( 0, 25, 800, 800);
        if(apts != null) {
            // Print the header at the top in a different font size then set the font back to little
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.setColor(Color.black);
            g.drawString(m + " " + numDay,325, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 12));

            // Print as im typing but clear once I reach the length
            if(!allApts.isEmpty()) {
                for (String s : allApts) {
                    g.drawString(s, 100, aptCoord);
                    aptCoord += 20;
                }
            }
            // Draw what is typed then set the pen back to white to cover the month when called again and
            // set the screen to day
            g.drawString(apts, 100, aptCoord + 15);
            g.setColor(Color.white);
            aptCoord = 150;
            cal.setScreen("Day");
        }
    }

}
