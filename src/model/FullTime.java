package model;

public class FullTime extends Staff{
    private int date;
    private double factor;

    public FullTime() {
    }

    public FullTime(int id, String username, String password, int date, double factor) {
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

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public double salary() {
        return factor *date*200000;
    }

    @Override
    public String toString() {
        return "FullTime{" +
                "Factor: " + factor +
                '}' + super.toString();
    }
}
