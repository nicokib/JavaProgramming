package be.abis.courseadmin.model;

public class Course {
    private String title;
    private int numberOfDays;
    private double pricePerDay;

    public Course() {
        this("", 0, 0.0);
    }

    public Course(String title, int numberOfDays, double pricePerDay) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void printInfo() {
        System.out.println(toString());
    }

    protected double calculateTotalPrice() {
        return pricePerDay * numberOfDays;
    }

    protected double calculateTotalPrice(double reducePercent) {
        return pricePerDay * numberOfDays * (1.0 - reducePercent / 100);
    }

    @Override
    public String toString() {
        String message = "Course - Title: " + getTitle() + ", number of days: " + getNumberOfDays() + ", price per day: " + getPricePerDay() + ", total price: " + calculateTotalPrice();
        return message;
    }
}
