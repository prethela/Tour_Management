

package TourManagement;
// File: CoxsBazar.java
public class CoxsBazar extends Tour {
    public CoxsBazar() {
        super("Cox's Bazar", 5, "Morning", "Buffet meals", "Sea View Hotel", 
              "August 5 - August 15", "Bus", 12000.0);
    }

    @Override
    public void showDetails() {
        System.out.println("=== Cox's Bazar Tour Details ===");
        System.out.println("Duration: " + duration + " days");
        System.out.println("Time: " + time);
        System.out.println("Meals: " + meals);
        System.out.println("Accommodation: " + accommodation);
        System.out.println("Available Dates: " + availableDates);
        System.out.println("Transport: " + transport);
        System.out.println("Price: Tk " + price);
    }
}
