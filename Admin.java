

package TourManagement;
// File: Admin.java
import java.util.ArrayList;

public class Admin {
    private ArrayList<Tour> tours;

    public Admin(ArrayList<Tour> tours) {
        this.tours = tours;
    }

    public void addTrip(Tour tour) {
        tours.add(tour);
        System.out.println("Trip added successfully: " + tour.getDestination());
    }

    public void updateTrip(String destination, double newPrice, String newDates) {
        for (Tour t : tours) {
            if (t.getDestination().equalsIgnoreCase(destination)) {
                t.setPrice(newPrice);
                t.setAvailableDates(newDates);
                System.out.println("Trip updated for: " + destination);
                return;
            }
        }
        System.out.println("Trip not found!");
    }

    public void deleteTrip(String destination) {
        tours.removeIf(t -> t.getDestination().equalsIgnoreCase(destination));
        System.out.println("Trip deleted: " + destination);
    }

    public void viewAllTrips() {
        System.out.println("\n All Available Trips:");
        for (Tour t : tours) {
            t.showDetails();
            System.out.println("----------------------------");
        }
    }
}
