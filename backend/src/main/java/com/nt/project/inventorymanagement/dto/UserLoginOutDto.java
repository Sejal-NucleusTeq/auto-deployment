package com.nt.project.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Sejal Jain.
 *
 */
public final class UserLoginOutDto {
    /**
     * role.
     */
    private String role;
    /**
     * first Name.
     */
    private String firstName;
    /**
     * employee id.
     */
    private String employeeId;
    /**
     * first login.
     */
    private boolean firstLogin;
    /**
     * @return status if first login
     */
    public boolean isFirstLogin() {
        return firstLogin;
    }
    /**
     * @param firstLogin : first login.
     */
    public void setFirstLogin(final boolean firstLogin) {
       this.firstLogin = firstLogin;
    }
    /**
     * @return employee id.
     */
    public String getEmployeeId() {
         return employeeId;
    }
    /**
     * @param employeeId : employee id.
     */
    public void setEmployeeId(final String employeeId) {
         this.employeeId = employeeId;
    }
    /**
     * @return role.
     */
    public String getRole() {
         return role;
    }
    /**
     * @param role : role of given user.
     */
    public void setRole(final String role) {
        this.role = role;
    }
    /**
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName : first name of given email.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * super constructor.
     */
    public UserLoginOutDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param role : role.
     * @param firstName : firstName.
     * @param employeeId : employeeId.
     * @param firstLogin : firstLogin.
     */
    public UserLoginOutDto(final String role, final String firstName, final String employeeId, final boolean firstLogin) {
        super();
        this.role = role;
        this.firstName = firstName;
        this.employeeId = employeeId;
        this.firstLogin = firstLogin;
    }
    /**
     * @param role : role.
     * @param firstName : firstName.
     */
    public UserLoginOutDto(final String role, final String firstName) {
        super();
        this.role = role;
        this.firstName = firstName;
    }
    /**
     * hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstLogin, firstName, role);
    }
    /**
     * equals.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserLoginOutDto other = (UserLoginOutDto) obj;
        return Objects.equals(employeeId, other.employeeId) && firstLogin == other.firstLogin
                && Objects.equals(firstName, other.firstName) && Objects.equals(role, other.role);
    }
    /**
     * to string method for LoginDtoOut.
     */
    @Override
    public String toString() {
        return "UserLoginOutDto [role=" + role + ", firstName=" + firstName + ", employeeId=" + employeeId
                + ", firstLogin=" + firstLogin + "]";
    }
}
