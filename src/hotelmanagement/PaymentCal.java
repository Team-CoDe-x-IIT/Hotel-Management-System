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
class PaymentCal {
    
    private String payCalId, guestId, roomId;
    private int facilityCharges, serviceCharges,totalBill;

    public PaymentCal(String payCalId, String guestId, String roomId, int facilityCharges, int serviceCharges, int totalBill) {
        this.payCalId = payCalId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.facilityCharges = facilityCharges;
        this.serviceCharges = serviceCharges;
        this.totalBill = totalBill;
    }

    public String getPayCalId() {
        return payCalId;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getFacilityCharges() {
        return facilityCharges;
    }

    public int getServiceCharges() {
        return serviceCharges;
    }

    public int getTotalBill() {
        return totalBill;
    }
    
    
    
}
