package com.nt.project.inventorymanagement.dto;
import java.util.Objects;

/**
 * @author Sejal Jain.
 *
 */
public final class ResetPwdOutDto {
    /**
     * message.
     */
    private String message;
    /**
     * @return the message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message : message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     *toString.
     */
    @Override
    public String toString() {
        return "ResetPwdOutDto [message=" + message + "]";
    }
    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message);
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
        ResetPwdOutDto other = (ResetPwdOutDto) obj;
        return Objects.equals(message, other.message);
    }
}
