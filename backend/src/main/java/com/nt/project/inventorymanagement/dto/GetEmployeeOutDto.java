package com.nt.project.inventorymanagement.dto;

import java.util.List;

import com.nt.project.inventorymanagement.domain.Item;

/**
 * @author Sejal Jain
 *
 */
public final class GetEmployeeOutDto {
    /**
     * employeeName.
     */
    private String employeeName;
    /**
     * email.
     */
    private String email;
    /**
     * employeeId.
     */
    private String employeeId;
    /**
     * phoneNo.
     */
    private String phoneNo;
    /**
     * getItem.
     */
    private List<Item> getItem;
    /**
     * @return the employeeName.
     */
    public String getEmployeeName() {
        return employeeName;
    }
    /**
     * @param employeeName : employeeName.
     */
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }
    /**
     * @return the email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email : email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    /**
     * @return the employeeId.
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId : employeeId.
     */
    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    /**
     * @param phoneNo : phoneNo.
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }
    /**
     * @return the getItem
     */
    public List<Item> getGetItem() {
        return getItem;
    }
    /**
     * @param getItem : getItem.
     */
    public void setGetItem(final List<Item> getItem) {
        this.getItem = getItem;
    }
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "GetEmployeeOutDto [employeeName=" + employeeName + ", email=" + email + ", employeeId=" + employeeId
                + ", phoneNo=" + phoneNo + ", getItem=" + getItem + "]";
    }
}
