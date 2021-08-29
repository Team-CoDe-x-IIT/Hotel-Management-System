/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.sql.Date;

/**
 *
 * @author Mahfooz
 */
class Hall {
    
    private String hallId, functionType, noOfGuests,reservationDate,guestId;

    public Hall(String hallId, String functionType, String noOfGuests, String reservationDate, String guestId) {
        this.hallId = hallId;
        this.functionType = functionType;
        this.noOfGuests = noOfGuests;
        this.reservationDate = reservationDate;
        this.guestId = guestId;
    }

    public String getHallId() {
        return hallId;
    }

    public String getFunctionType() {
        return functionType;
    }

    public String getNoOfGuests() {
        return noOfGuests;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getGuestId() {
        return guestId;
    }
    
    
    
    
    
}
