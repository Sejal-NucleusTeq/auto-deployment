package com.nt.project.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Sejal Jain UserOutDto Class for Response
 *
 */
public final class UserOutDto {
    /**
     * message : msg.
     */
    private String message;
    /**
     * @return message.
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
     * toString method.
     */
    @Override
    public String toString() {
        return "UserOutDto [message=" + message + "]";
    }
    /**
     * hashCode.
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
        UserOutDto other = (UserOutDto) obj;
        return Objects.equals(message, other.message);
    }
}
