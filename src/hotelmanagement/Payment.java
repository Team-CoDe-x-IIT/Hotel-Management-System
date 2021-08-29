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
class Payment {
    
    private String payId, reservationType, paymentMethod, email;

    public Payment(String payId, String reservationType, String paymentMethod, String email) {
        this.payId = payId;
        this.reservationType = reservationType;
        this.paymentMethod = paymentMethod;
        this.email = email;
    }

    public String getPayId() {
        return payId;
    }

    public String getReservationType() {
        return reservationType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
