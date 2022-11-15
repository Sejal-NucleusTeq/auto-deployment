package com.nt.project.inventorymanagement.dto;
import java.util.Objects;
/**
 * @author Sejal Jain.
 *
 */
public final class UserLoginInDto {
    /**
     * email : email.
     */
    private String email;
    /**
     * password : password.
     */
    private String password;
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
     * get password.
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
     * super constructor.
     */
    public UserLoginInDto() {
    }
    /**
     * @param email : email.
     * @param password : pwd.
     */
    public UserLoginInDto(final String email, final String password) {
        super();
        this.email = email;
        this.password = password;
    }
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "UserLoginInDto [email=" + email + ", password=" + password + "]";
    }
    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
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
        UserLoginInDto other = (UserLoginInDto) obj;
        return Objects.equals(email, other.email)
                && Objects.equals(password, other.password);
    }
}
