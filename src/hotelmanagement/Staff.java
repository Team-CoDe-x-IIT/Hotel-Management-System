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
class Staff {
    
    private String staffId, employeeName, gender,email, nic;
    private int phoneNumber;

    public Staff(String staffId, String employeeName, String gender, int phoneNumber, String email, String nic ) {
        this.staffId = staffId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.email = email;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getNic() {
        return nic;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    
    
    
    
    
}
