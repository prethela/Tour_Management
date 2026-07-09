

package TourManagement;

import java.io.*;
import java.util.ArrayList;

public class TourFileManager {
    private static final String FILE_NAME = "tours.ser";

    public static void saveTours(ArrayList<Tour> tours) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(tours);
        } catch (IOException e) {
            System.out.println("Failed to save tour data: " + e.getMessage());
        }
    }

    public static ArrayList<Tour> loadTours() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Tour>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ Starting with default tour list...");
            return null;
        }
    }
} 
