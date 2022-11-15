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
public  final class EmployeeInDto {
    /**
     * minimum name lenght.
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
     * get id.
     * @return id.
     */
    public  int getUserId() {
        return userId;
    }
    /**
     * set id.
     * @param userId : userId.
     */
    public  void setUserId(final int userId) {
        this.userId = userId;
    }
    /**
     * get firstName.
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * set firstName.
     * @param firstName : firstName.
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
     * @param lastName : lastName.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * get employeeId.
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
     * get email.
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * set emiail.
     * @param email : email.
     */
    public void setEmail(final String email) {
        this.email = email;
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
     * get desiganation.
     * @return desiganation.
     */
    public String getDesiganation() {
        return desiganation;
    }
    /**
     * set desiganation.
     * @param desiganation : desiganation.
     */
    public void setDesiganation(final String desiganation) {
        this.desiganation = desiganation;
    }
    /**
     * get dateOfjoining.
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
     * get phoneNo.
     * @return phoneNo.
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    /**
     * set phoneNo.
     * @param phoneNo : phoneNo;
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }
    /**
     * get dateOfExit.
     * @return dateOfExit.
     */
    public String getDateOfExit() {
        return dateOfExit;
    }
    /**
     * set dateOfExit.
     * @param dateOfExit : dateOfExit .
     */
    public void setDateOfExit(final String dateOfExit) {
        this.dateOfExit = dateOfExit;
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
     * tostring method.
     */
    @Override
    public String toString() {
        return "EmployeeDto [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeId="
                + employeeId + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", desiganation=" + desiganation
                + ", dateOfJoining=" + dateOfJoining + ", role=" + role + ", phoneNo=" + phoneNo + ", dateOfExit="
                + dateOfExit + "]";
    }
    /**
     * hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(createdAt, dateOfBirth, dateOfExit, dateOfJoining, desiganation, email, employeeId,
                firstName, userId, lastName, phoneNo, role, updatedAt, location);
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
        EmployeeInDto other = (EmployeeInDto) obj;
        return Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(dateOfExit, other.dateOfExit) && Objects.equals(dateOfJoining, other.dateOfJoining)
                && Objects.equals(desiganation, other.desiganation) && Objects.equals(email, other.email)
                && Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
                && userId == other.userId && Objects.equals(lastName, other.lastName) && Objects.equals(phoneNo, other.phoneNo)
                && Objects.equals(role, other.role)
                && Objects.equals(location, other.location);
    }
}
