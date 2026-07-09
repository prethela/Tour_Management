
package TourManagement;
// File: User.java
// File: User.java
import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String nid;
    private String phoneNumber;
    private int numberOfPeople;
    private boolean wantsGuide;

    public User(String name, String nid, String phoneNumber, int numberOfPeople, boolean wantsGuide) {
        this.name = name;
        this.nid = nid;
        this.phoneNumber = phoneNumber;
        this.numberOfPeople = numberOfPeople;
        this.wantsGuide = wantsGuide;
    }

    public String getName() {
        return name;
    }

    public String getNid() {
        return nid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public boolean isWantsGuide() {
        return wantsGuide;
    }

    public void showUserInfo() {
        System.out.println("User Name: " + name);
        System.out.println("NID: " + nid);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Total People: " + numberOfPeople);
        System.out.println("Guide Needed: " + (wantsGuide ? "Yes" : "No"));
    }
}
