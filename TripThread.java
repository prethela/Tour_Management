
package TourManagement;
// File: TripThread.java
public class TripThread extends Thread {
    private String destination;

    public TripThread(String destination) {
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println("\nPreparing your trip to " + destination + "...");
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Loading step " + i + "...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("️ Preparation interrupted.");
        }
        System.out.println(" Trip to " + destination + " is ready!");
    }
}
