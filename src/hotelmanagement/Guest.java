/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

/**
 *
 * @author Mahfooz
 */
class Guest {
    
    private String guestId, name, type, nic, email,packageType;
    private int phoneNumber;
    private boolean swimming,gym,diving,boatRide;

    public Guest(String guestId, String name, String type, String nic,int phoneNumber, String email, String packageType, boolean swimming, boolean gym, boolean diving, boolean boatRide) {
        this.guestId = guestId;
        this.name = name;
        this.type = type;
        this.nic = nic;
        this.email = email;
        this.packageType = packageType;
        this.phoneNumber = phoneNumber;
        this.swimming = swimming;
        this.gym = gym;
        this.diving = diving;
        this.boatRide = boatRide;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNic() {
        return nic;
    }

    public String getEmail() {
        return email;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isSwimming() {
        return swimming;
    }

    public boolean isGym() {
        return gym;
    }

    public boolean isDiving() {
        return diving;
    }

    public boolean isBoatRide() {
        return boatRide;
    }
    
    
}
