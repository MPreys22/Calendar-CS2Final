public class Day {
    private int numDay;
    private int numApts;
    private String apts;

    public Day(int numDay) {
        this.numDay = numDay;
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
        this.apts = this.apts + ", " + apt;
    }

}
