package com.nt.project.inventorymanagement.dto;
import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Sejal Jain.
 */
public final class UserInDto {
    /**
     * minimum : lenght.
     */
    private static final int MINNAME = 2;
    /**
     * minimum : lenght.
     */
    private static final int MINPASSWORD = 8;
    /**
     * maximum : lenght.
     */
    private static final int MAXPASSWORD = 32;
    /**
     * Phone No lenght.
     */
    private static final int PHONENO = 10;
    /**
     * id is for userId.
     */
    private int id;
    /**
     * firstName : firstName.
     */
    @NotEmpty(message = "First Name Can Not Be Empty!")
    @Size(min = MINNAME, message = "Firstname must be minimum of 2 characters")
    private String firstName;
    /**
     * lastName : lastName.
     */
    @NotEmpty(message = "Last Name Can Not Be Empty!")
    @Size(min = MINNAME, message = "Lastname must be minimum of 2 characters")
    private String lastName;
    /**
     * employeeId : empId..
     */
    @NotEmpty(message = "Employee Id Can Not Be Empty!")
    private String employeeId;
    /**
     * email : email.
     */
    @NotEmpty(message = "Email Can Not Be Empty!")
    @Email(message = "Email address is not valid !!")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com$", message = "Company Email is Valid Only")
    private String email;
    /**
     * password : pwd.
     */
    @NotEmpty(message = "Password Can Not Be Empty!")
    @Size(min = MINPASSWORD, max = MAXPASSWORD, message = "Password must be minimum of 8 and maximum of 16")
    private String password;
    /**
     * dateOfBirth : dob.
     */
    @NotEmpty(message = "Date of Birth Can Not Be Empty!")
    private String dateOfBirth;
    /**
     * phoneNo : phoneNo.
     */
    @NotNull
    @NotEmpty(message = "Phone NO Can Not Be Empty!")
    @Size(min = PHONENO, max = PHONENO, message = "It should contains minimum 10 and maximum 10 numbers")
    @Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
    private String phoneNo;
    /**
     * desiganation : desiganation.
     */
    @NotEmpty(message = "desiganation Can Not Be Empty!")
    private String desiganation;
    /**
     * dateOfJoining : doj.
     */
    private String dateOfJoining;
    /**
     * role : role.
     */
    private String role;
    /**
     * dateOfExit : date.
     */
    private String dateOfExit;
    /**
     * location : location.
     */
    private String location;
    /**
     * firstLogin : firstLogin.
     */
    private Boolean firstLogin;
    /**
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id id.
     */
    public void setId(final int id) {
        this.id = id;
    }
    /**
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName : fname.
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
     * @param employeeId2 : employeeId.
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
     * @return password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password : password.
     */
    public void setPassword(final String password) {
        this.password = password;
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
     * @param desiganation designation.
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
     * @param dateOfExit : dateofExit.
     */
    public void setDateOfExit(final String dateOfExit) {
        this.dateOfExit = dateOfExit;
    }
    /**
     * @return the firstLogin
     */
    public Boolean getFirstLogin() {
        return firstLogin;
    }
    /**
     * @param firstLogin the firstLogin to set
     */
    public void setFirstLogin(final Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
    /**
     * tostring method.
     */
    @Override
    public String toString() {
        return "UserInDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeId="
                + employeeId + ", email=" + email + ", password=" + password + ", dateOfBirth=" + dateOfBirth
                + ", phoneNo=" + phoneNo + ", desiganation=" + desiganation + ", dateOfJoining=" + dateOfJoining
                + ", role=" + role + ", dateOfExit=" + dateOfExit + ", location=" + location + ", firstLogin="
                + firstLogin + "]";
    }
    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, dateOfExit, dateOfJoining, desiganation, email, employeeId, firstLogin,
                firstName, id, lastName, location, password, phoneNo, role);
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
        UserInDto other = (UserInDto) obj;
        return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(dateOfExit, other.dateOfExit)
                && Objects.equals(dateOfJoining, other.dateOfJoining)
                && Objects.equals(desiganation, other.desiganation) && Objects.equals(email, other.email)
                && Objects.equals(employeeId, other.employeeId) && Objects.equals(firstLogin, other.firstLogin)
                && Objects.equals(firstName, other.firstName) && id == other.id
                && Objects.equals(lastName, other.lastName) && Objects.equals(location, other.location)
                && Objects.equals(password, other.password) && Objects.equals(phoneNo, other.phoneNo)
                && Objects.equals(role, other.role);
    }
}
