import java.awt.*;

public class Day {
    private int numDay;
    private int numApts;
    private String apts;
    private CalendarView calView;
    private Month m;

    public Day(int numDay, CalendarView window, Month month) {
        calView = window;
        this.numDay = numDay;
        apts = "";
        m = month;
    }

    public int getNumDay() {
        return this.numDay;
    }

    public int getNumApts() {
        return this.numApts;
    }

    public String getApts() {
        return this.apts;
    }

    public void setApts(String apt) {
        if(apts.equals("")) {
            apts = apt;
        }
        else {
            apts = apts + apt;
        }
    }

    public void draw(Graphics g) {
        g.fillRect( 0, 25, 800, 800);
        if(apts != null) {
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.setColor(Color.black);
            g.drawString(m.getMonth() + " " + numDay,325, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 12));
            g.drawString(apts, 100, 150);
            g.setColor(Color.white);
=        }
    }

}
