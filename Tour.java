

package TourManagement;
// File: Tour.java
import java.io.Serializable;

public abstract class Tour implements Serializable {
    protected String destination;
    protected int duration; // in days
    protected String time; // Morning, Evening, etc.
    protected String meals;
    protected String accommodation;
    protected String availableDates;
    protected String transport; // Train/Bus
    protected double price;
    protected int currentBookings = 0;

    public Tour(String destination, int duration, String time, String meals,
                String accommodation, String availableDates, String transport, double price) {
        this.destination = destination;
        this.duration = duration;
        this.time = time;
        this.meals = meals;
        this.accommodation = accommodation;
        this.availableDates = availableDates;
        this.transport = transport;
        this.price = price;
    }

    public abstract void showDetails();

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    // Setters for admin update functionality
    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableDates(String availableDates) {
        this.availableDates = availableDates;
    }

    public int getCurrentBookings() {
        return currentBookings;
    }

    public void addBooking(int people) {
        this.currentBookings += people;
    }
}
