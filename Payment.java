

package TourManagement;
// File: Payment.java
public class Payment {
    public static void processPayment(String method, double amount) {
        System.out.println("\nPayment Method: " + method);
        if (method.equalsIgnoreCase("credit")) {
            System.out.println("Processing credit card payment of Tk " + amount + "...");
        } else {
            System.out.println("Processing cash payment of Tk " + amount + "...");
        }

        try {
            Thread.sleep(2000); // simulate processing time
        } catch (InterruptedException e) {
            System.out.println("Payment interrupted!");
        }

        System.out.println("Payment successful! Thank you.");
    }
}
