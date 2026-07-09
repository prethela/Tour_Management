

package TourManagement;
// File: TourManager.java
import java.util.*;

public class TourManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tour> tours = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // ✅ Load tours from file if available
        ArrayList<Tour> loadedTours = TourFileManager.loadTours();
        if (loadedTours != null) {
            tours = loadedTours;
        } else {
            tours.add(new Sylhet());
            tours.add(new Bandarban());
            tours.add(new CoxsBazar());
        }

        Admin admin = new Admin(tours);

        while (true) {
            System.out.println("\n=== Tour Management System ===");
            System.out.println("1. User Panel");
            System.out.println("2. Admin Panel");
            System.out.println("3. Exit");
            int choice = InputHelper.getInt("Choose option: ");

            switch (choice) {
                case 1:
                    handleUser(tours, bookings);
                    break;
                case 2:
                    handleAdmin(admin, tours, bookings);
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleUser(ArrayList<Tour> tours, ArrayList<Booking> bookings) {
        System.out.println("\n--- Register New User ---");
        String name = InputHelper.getString("Enter your name: ");
        String nid = InputHelper.getString("Enter your NID: ");
        String phone = InputHelper.getString("Enter your phone number: ");
        int people = InputHelper.getInt("Enter number of people: ");
        boolean guide = InputHelper.getBoolean("Do you want a guide?");

        User user = new User(name, nid, phone, people, guide);

        System.out.println("\nAvailable Destinations:");
        for (int i = 0; i < tours.size(); i++) {
            System.out.println((i + 1) + ". " + tours.get(i).getDestination());
        }

        int destIndex = InputHelper.getInt("Choose destination (1-" + tours.size() + "): ") - 1;
        if (destIndex < 0 || destIndex >= tours.size()) {
            System.out.println("Invalid destination.");
            return;
        }

        Tour selectedTour = tours.get(destIndex);

        int availableSeats = 300 - selectedTour.getCurrentBookings();
        if (availableSeats == 0) {
            System.out.println("❌ Sorry, all seats for " + selectedTour.getDestination() + " tour are fully booked!");
            return;
        } else if (people > availableSeats) {
            System.out.println("⚠️ Only " + availableSeats + " seats are available. Please enter a smaller number of people.");
            return;
        }

        boolean meal = InputHelper.getBoolean("Do you want to include meals?");
        Booking booking = new Booking(user, selectedTour, meal);
        bookings.add(booking);
        selectedTour.addBooking(people);
        TourFileManager.saveTours(tours);

        booking.showBooking();
        BookingFileManager.saveBooking(booking);

        String method = InputHelper.getString("Payment Method (Credit/Cash): ");
        Payment.processPayment(method, selectedTour.getPrice() * user.getNumberOfPeople());

        TripThread tripThread = new TripThread(selectedTour.getDestination());
        tripThread.start();
    }

    private static void handleAdmin(Admin admin, ArrayList<Tour> tours, ArrayList<Booking> bookings) {
        String password = InputHelper.getString("Enter Admin Password: ");
        if (!password.equals("admin123")) {
            System.out.println("Wrong password.");
            return;
        }

        while (true) {
            System.out.println("\n--- Admin Panel ---");
            System.out.println("1. View All Trips");
            System.out.println("2. Add Trip");
            System.out.println("3. Update Trip");
            System.out.println("4. Delete Trip");
            System.out.println("5. Reset All Data");
            System.out.println("6. Back to Main Menu");

            int choice = InputHelper.getInt("Choose option: ");
            switch (choice) {
                case 1:
                    admin.viewAllTrips();
                    break;
                case 2:
                    addNewTour(admin);
                    break;
                case 3:
                    updateTour(admin);
                    break;
                case 4:
                    deleteTour(admin);
                    break;
                case 5:
                    resetAllData(tours, bookings);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void resetAllData(ArrayList<Tour> tours, ArrayList<Booking> bookings) {
        System.out.println("Are you sure you want to reset all data? (Yes/No)");
        String confirmation = InputHelper.getString("Enter your choice: ").toLowerCase();
        if (confirmation.equals("yes")) {
            bookings.clear();
            tours.clear();
            tours.add(new Sylhet());
            tours.add(new Bandarban());
            tours.add(new CoxsBazar());

            TourFileManager.saveTours(tours);
            BookingFileManager.saveBookings(bookings);
            System.out.println("✅ All data has been reset.");
        } else {
            System.out.println("❌ Data reset canceled.");
        }
    }

    private static void addNewTour(Admin admin) {
        String dest = InputHelper.getString("Enter destination name: ");
        int dur = InputHelper.getInt("Enter duration (days): ");
        String time = InputHelper.getString("Enter time (Morning/Evening): ");
        String meals = InputHelper.getString("Enter meals info: ");
        String accom = InputHelper.getString("Enter accommodation: ");
        String dates = InputHelper.getString("Enter available dates: ");
        String trans = InputHelper.getString("Enter transport info: ");
        double price = InputHelper.getDouble("Enter price: ");

        Tour newTour = new Tour(dest, dur, time, meals, accom, dates, trans, price) {
            @Override
            public void showDetails() {
                System.out.println("Custom Tour to " + destination);
            }
        };
        admin.addTrip(newTour);
    }

    private static void updateTour(Admin admin) {
        String updateDest = InputHelper.getString("Enter destination to update: ");
        double newPrice = InputHelper.getDouble("Enter new price: ");
        String newDates = InputHelper.getString("Enter new available dates: ");
        admin.updateTrip(updateDest, newPrice, newDates);
    }

    private static void deleteTour(Admin admin) {
        String delDest = InputHelper.getString("Enter destination to delete: ");
        admin.deleteTrip(delDest);
    }
}
