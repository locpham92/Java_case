package model;

public class PartTime extends Staff{
    private int date;
    private double factor;
    public PartTime() {
    }

    public PartTime(int id, String username, String password, int date, double factor) {
        super(id, username, password);
        this.date = date;
        this.factor = factor;
    }
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public double salary() {
        return factor*date*30000;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                "Factor: " + factor +
                "} " + super.toString();
    }
}
