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
class Salary {
    
    private String salaryId, staffId;
    private int workingDays, basicSalary, otHours, netPay;

    public Salary(String salaryId, String staffId, int workingDays, int basicSalary, int otHours, int netPay) {
        this.salaryId = salaryId;
        this.staffId = staffId;
        this.workingDays = workingDays;
        this.basicSalary = basicSalary;
        this.otHours = otHours;
        this.netPay = netPay;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public String getStaffId() {
        return staffId;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public int getOtHours() {
        return otHours;
    }

    public int getNetPay() {
        return netPay;
    }
    
    
    
}
