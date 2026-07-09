

package TourManagement;
// File: Bandarban.java
public class Bandarban extends Tour {
    public Bandarban() {
        super("Bandarban", 4, "Evening", "2 meals/day", "Resort", 
              "July 1 - July 10", "Bus", 9500.0);
    }

    @Override
    public void showDetails() {
        System.out.println("=== Bandarban Tour Details ===");
        System.out.println("Duration: " + duration + " days");
        System.out.println("Time: " + time);
        System.out.println("Meals: " + meals);
        System.out.println("Accommodation: " + accommodation);
        System.out.println("Available Dates: " + availableDates);
        System.out.println("Transport: " + transport);
        System.out.println("Price: Tk " + price);
    }
}
