

package TourManagement;
// File: Sylhet.java
public class Sylhet extends Tour {
    public Sylhet() {
        super("Sylhet", 3, "Morning", "3 meals/day", "Hotel", 
              "June 10 - June 20", "Train", 8000.0);
    }

    @Override
    public void showDetails() {
        System.out.println("=== Sylhet Tour Details ===");
        System.out.println("Duration: " + duration + " days");
        System.out.println("Time: " + time);
        System.out.println("Meals: " + meals);
        System.out.println("Accommodation: " + accommodation);
        System.out.println("Available Dates: " + availableDates);
        System.out.println("Transport: " + transport);
        System.out.println("Price: Tk " + price);
    }
}
