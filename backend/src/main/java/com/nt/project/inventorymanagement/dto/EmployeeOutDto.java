package com.nt.project.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Sejal Jain
 * UserOutDto Class for Response.
 *
 */
public final class EmployeeOutDto {
    /**
     * message.
    */
    private String message;
    /**
    * get message.
     * @return message.
     */
    public String getMessage() {
        return message;
    }
    /**
    * set message.
     * @param message : message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }
    /**
    *toString method.
    */
    @Override
    public String toString() {
        new Object();
        return "UserOutDto [message=" + message + "]";
    }
    /**
     * equals.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
    /**
     * hashcode.
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
        EmployeeOutDto other = (EmployeeOutDto) obj;
        return Objects.equals(message, other.message);
    }
}
