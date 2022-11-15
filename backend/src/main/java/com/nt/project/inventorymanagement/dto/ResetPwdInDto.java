package com.nt.project.inventorymanagement.dto;
import java.util.Objects;

/**
 * @author Sejal Jain
 *
 */
public final class ResetPwdInDto {
    /**
     * password.
     */
    private String password;
    /**
     * confirmPassword.
     */
    private String confirmPassword;
    /**
     * @return the password.
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
     * @return the confirmPassword.
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }
    /**
     * @param confirmPassword : confirmPassword.
     */
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    /**
     *tostring.
     */
    @Override
    public String toString() {
        return "ResetPwdInDto [password=" + password + ", confirmPassword=" + confirmPassword + "]";
    }
    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(confirmPassword, password);
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
        ResetPwdInDto other = (ResetPwdInDto) obj;
        return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(password, other.password);
    }
}
