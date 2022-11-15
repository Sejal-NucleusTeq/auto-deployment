package com.nt.project.inventorymanagement.dto;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * @author NucleusTeq Device.
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
public final class UpdateEmployeeInDto {
    /**
     * MINNAME.
     */
    private static final int MINNAME = 2;
    /**
     * Phone No lenght.
     */
    private static final int PHONENO = 10;
    /**
     * id is for EmployeeId.
     */
    private int userId;
    /**
     * for Employee first Name.
     */
    @NotEmpty(message = "First Name Can Not Be Empty!")
    @Size(min = MINNAME, message = "Firstname must be minimum of 2 characters")
    private String firstName;
    /**
     * for Employee last Name.
     */
    @NotEmpty(message = "Last Name Can Not Be Empty!")
    @Size(min = MINNAME, message = "Lastname must be minimum of 2 characters")
    private String lastName;
    /**
     * for Employee employee ID.
     */
    @NotEmpty(message = "Employee Id Can Not Be Empty!")
    private String employeeId;
    /**
     * for Employee Email.
     */
    @NotEmpty(message = "Email Can Not Be Empty!")
    @Email(message = "Email address is not valid !!")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com$", message = "Company Email is Valid Only")
    private String email;
    /**
     * for Employee date of birth.
     */
    @NotEmpty(message = "Date of Birth Can Not Be Empty!")
    private String dateOfBirth;
    /**
     * for Employee phone number.
     */
    @NotNull
    @NotEmpty(message = "Phone NO Can Not Be Empty!")
    @Size(min = PHONENO, max = PHONENO, message = "It should contains minimum 10 and maximum 10 numbers")
    @Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
    private String phoneNo;
    /**
     * Employee designation.
     */
    @NotEmpty(message = "desiganation Can Not Be Empty!")
    private String desiganation;
    /**
     * Employee date of joining.
     */
    private String dateOfJoining;
    /**
     * Employee role.
     */
    private String role;
    /**
     * Employee date of exit.
     */
    private String dateOfExit;
    /**
     * location.
     */
    private String location;
    /**
     * Table Creation Date.
     */
    private String createdAt;

    /**
     * Last Updated Date.
     */
    private String updatedAt;
    /**
     * @return id.
     */
    public  int getUserId() {
        return userId;
    }
    /**
     * @param userId : userId.
     */
    public  void setUserId(final int userId) {
        this.userId = userId;
    }
    /**
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName : firstName.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName : lastName.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return employeeId.
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId2 : employeeId2.
     */
    public void setEmployeeId(final String employeeId2) {
        this.employeeId = employeeId2;
    }
    /**
     * @return email.
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
     * @return dateOfBirth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * @param dateOfBirth : dateOfBirth.
     */
    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * @return desiganation.
     */
    public String getDesiganation() {
        return desiganation;
    }
    /**
     * @param desiganation : desiganation.
     */
    public void setDesiganation(final String desiganation) {
        this.desiganation = desiganation;
    }
    /**
     * @return dateOfJoining.
     */
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    /**
     * @param dateOfJoining : dateOfJoining.
     */
    public void setDateOfJoining(final String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    /**
     * @return role.
     */
    public String getRole() {
        return role;
    }
    /**
     * @param role : role.
     */
    public void setRole(final String role) {
        this.role = role;
    }
    /**
     * @return phoneNo.
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    /**
     * @param phoneNo : phoneNo;
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }
    /**
     * @return dateOfExit.
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
     * @return the location.
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
     *toString.
     */
    @Override
    public String toString() {
        return "UpdateEmployeeInDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", employeeId=" + employeeId + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", phoneNo="
                + phoneNo + ", desiganation=" + desiganation + ", dateOfJoining=" + dateOfJoining + ", role=" + role
                + ", dateOfExit=" + dateOfExit + ", location=" + location + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }
    /**
     *hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(createdAt, dateOfBirth, dateOfExit, dateOfJoining, desiganation, email, employeeId,
                firstName, lastName, location, phoneNo, role, updatedAt, userId);
    }
    /**
     *equals.
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
        UpdateEmployeeInDto other = (UpdateEmployeeInDto) obj;
        return Objects.equals(createdAt, other.createdAt) && Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(dateOfExit, other.dateOfExit) && Objects.equals(dateOfJoining, other.dateOfJoining)
                && Objects.equals(desiganation, other.desiganation) && Objects.equals(email, other.email)
                && Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName) && Objects.equals(location, other.location)
                && Objects.equals(phoneNo, other.phoneNo) && Objects.equals(role, other.role)
                && Objects.equals(updatedAt, other.updatedAt) && userId == other.userId;
    }
    /**
     * superconstructor.
     */
    public UpdateEmployeeInDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param userId : id.
     * @param firstName : fname.
     * @param lastName : lname.
     * @param employeeId : id.
     * @param email : email.
     * @param dateOfBirth : dob.
     * @param phoneNo : phoneNo.
     * @param desiganation : desg.
     * @param dateOfJoining : doj.
     * @param role : role.
     */
    public UpdateEmployeeInDto(final int userId, final String firstName, final String lastName,
            final String employeeId, final String email, final String dateOfBirth, final String phoneNo,
            final String desiganation, final String dateOfJoining,
            final String role) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNo = phoneNo;
        this.desiganation = desiganation;
        this.dateOfJoining = dateOfJoining;
        this.role = role;
    }
}
