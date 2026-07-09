

package TourManagement;
// File: BookingFileManager.java
import java.io.*;
import java.util.ArrayList;

public class BookingFileManager {
    public static void saveBooking(Booking booking) {
        String fileName = booking.getDestination() + ".txt";
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Booking for " + booking.getUserName());
            bw.newLine();
            bw.write("Destination: " + booking.getDestination());
            bw.newLine();
            bw.write("----------------------------");
            bw.newLine();

            System.out.println("Booking saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }// Method to save multiple bookings at once
 public static void
saveBookings(ArrayList<Booking> bookings)
{
 for (Booking booking : bookings) {
 saveBooking(booking); // Save each booking using the saveBooking method
 }
 }

 public static ArrayList<Booking>loadBookings() {
 
 return new ArrayList<>(); //Return empty list as placeholder
 }
}
