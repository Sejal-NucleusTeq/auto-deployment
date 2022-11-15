package com.nt.project.inventorymanagement.domain;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nt.project.inventorymanagement.domain.support.Support;
/**
 * @author Sejal Jain.
 *
 */
/**
 * @author Sejal Jain
 *
 */
/**
 * @author Sejal Jain
 *
 */
/**
 * @author Sejal Jain
 *
 */
/**
 * @author Sejal Jain
 *
 */
/**
 * @author Sejal Jain
 *
 */
@Entity
@Table(name = "user", schema = "public")
public final class User extends Support {
    /**
     * UserId is for userId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    /**
     * First name is for firstName.
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * Last name is for lastName.
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * Email is for email.
     */
    @Column(name = "email", unique = true)
    private String email;
    /**
     * Phone Number is for phoneNo.
     */
    @Column(name = "phone_no", unique = true)
    private String phoneNo;
    /**
     * Password is for password.
     */
    @Column(name = "password")
    private String password;
    /**
     * Role is for role.
     */
    @Column(name = "role")
    private String role;
    /**
     * employee_id is for employeeid.
     */
    @Column(name = "employee_id", unique = true)
    private String employeeId;
    /**
     * Designation is for designation.
     */
    @Column(name = "desiganation")
    private String desiganation;
    /**
     * DateOfJoining is for dateOfJoining.
     */
    @Column(name = "date_of_joining")
    private String dateOfJoining;
    /**
     * DateOfBirth is for dateOfBirth.
     */
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    /**
     * location.
     */
    @Column(name = "location")
    private String location;
    /**
     * dateOfExit.
     */
    @Column(name = "date_of_exit")
    private String dateOfExit;
    /**
     * firstLogin.
     */
    @Column(name = "is_login_first")
    private Boolean firstLogin;
    /**
     * @return empid.
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
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * set firstName.
     * @param firstName : fname.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * get lastName.
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * set lastName.
     * @param lastName : lname.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * get id.
     * @return userId.
     */
    public Integer getuserId() {
        return userId;
    }
    /**
     * set id.
     * @param userId : Id.
     */
    public void setuserId(final Integer userId) {
        this.userId = userId;
    }
    /**
     * get role.
     * @return role.
     */
    public String getRole() {
        return role;
    }
    /**
     * set role.
     * @param role : role.
     */
    public void setRole(final String role) {
        this.role = role;
    }
    /**
     * get designation.
     * @return designation.
     */
    public String getDesiganation() {
        return desiganation;
    }
    /**
     * set designation.
     * @param desiganation : desiganation
     */
    public void setDesiganation(final String desiganation) {
        this.desiganation = desiganation;
    }
    /**
     * get email.
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * set email.
     * @param email : email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * get phoneNo.
     * @return phoneNo.
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    /**
     * set phoneNo.
     * @param phoneNo : phoneNo.
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }
    /**
     * get password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * set password.
     * @param password : password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
    /**
     * get dateOfJoining.
     * @return dateOfJoining.
     */
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    /**
     * set dateOfJoining.
     * @param dateOfJoining : dateOfJoining.
     */
    public void setDateOfJoining(final String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    /**
     * get dateOfBirth.
     * @return dateOfBirth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * set dateOfBirth.
     * @param dateOfBirth : dateOfBirth.
     */
    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location : location.
     */
    public void setLocation(final String location) {
        this.location = location;
    }
    /**
     * @return the dateOfExit.
     */
    public String getDateOfExit() {
        return dateOfExit;
    }
    /**
     * @param dateOfExit : dateOfExit.
     */
    public void setDateOfExit(final String dateOfExit) {
        this.dateOfExit = dateOfExit;
    }
    /**
     * @return the firstLogin.
     */
    public Boolean isFirstLogin() {
        return firstLogin;
    }
    /**
     * @param firstLogin the firstLogin to set
     */
    public void setFirstLogin(final Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phoneNo=" + phoneNo + ", password=" + password + ", role=" + role + ", employeeId=" + employeeId
                + ", desiganation=" + desiganation + ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth
                + ", location=" + location + ", dateOfExit=" + dateOfExit + ", firstLogin=" + firstLogin + "]";
    }
    /**
     * super Constructor.
     */
    public User() {
    }
    /**
     * @param userId : id.
     * @param firstName : fname.
     * @param email : email.
     * @param phoneNo : phoneNo.
     * @param password : pwd.
     * @param role : role.
     * @param employeeId : id.
     * @param desiganation : desiganation.
     * @param firstLogin : firstLogin.
     */
    public User(final int userId, final String firstName, final String email, final String phoneNo, final String password, final String role,
            final String employeeId,
            final String desiganation, final
            Boolean firstLogin) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.role = role;
        this.employeeId = employeeId;
        this.desiganation = desiganation;
        this.firstLogin = firstLogin;
    }
    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, dateOfExit, dateOfJoining, desiganation, email, employeeId, firstLogin,
                firstName, lastName, location, password, phoneNo, role, userId);
    }
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
        User other = (User) obj;
        return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(dateOfExit, other.dateOfExit)
                && Objects.equals(dateOfJoining, other.dateOfJoining)
                && Objects.equals(desiganation, other.desiganation) && Objects.equals(email, other.email)
                && Objects.equals(employeeId, other.employeeId) && firstLogin == other.firstLogin
                && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(location, other.location) && Objects.equals(password, other.password)
                && Objects.equals(phoneNo, other.phoneNo) && Objects.equals(role, other.role) && userId == other.userId;
    }
}
