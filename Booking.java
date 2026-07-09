

package TourManagement;
// File: Booking.java
import java.io.Serializable;

public class Booking implements Serializable {
    private User user;
    private Tour tour;
    private boolean mealIncluded;
    private double discount;
    private double finalPrice;

   // File: Booking.java (Updated)
public Booking(User user, Tour tour, boolean mealIncluded) {
    this.user = user;
    this.tour = tour;
    this.mealIncluded = mealIncluded;

    // Automatically set discount
    if (user.getNumberOfPeople() > 3) {
        this.discount = 10.0; // 10% discount
    } else {
        this.discount = 0.0;
    }

    calculateFinalPrice();
}


   private void calculateFinalPrice() {
 finalPrice = tour.getPrice() * 
user.getNumberOfPeople();
if (mealIncluded)
    finalPrice += 1000 * user.getNumberOfPeople();
 if (discount > 0) finalPrice -= 
finalPrice * (discount / 100.0);
 }

    public void showBooking() {
        System.out.println("\n=== Booking Details ===");
        user.showUserInfo();
        tour.showDetails();
        System.out.println("Meals Included: " + (mealIncluded ? "Yes (+Tk 1000)" : "No"));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: Tk " + finalPrice);
    }

    public String getDestination() {
        return tour.getDestination();
    }

    public String getUserName() {
        return user.getName();
    }
}
