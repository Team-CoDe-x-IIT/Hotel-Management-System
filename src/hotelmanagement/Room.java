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
class Room {
    
    private String roomId, guestId, roomtype, checkIn, checkOut;
    private int noOfAdult, noOfChildren;

    public Room(String roomId, String guestId, String roomtype, String checkIn, String checkOut, int noOfAdult, int noOfChildren) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.roomtype = roomtype;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.noOfAdult = noOfAdult;
        this.noOfChildren = noOfChildren;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public int getNoOfAdult() {
        return noOfAdult;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }
    
    
    
}
