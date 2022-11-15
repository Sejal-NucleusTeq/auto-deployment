package com.nt.project.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Sejal Jain.
 *
 */
public final class AssignItemOutDto {
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
     * @param message : toString.
     */
    public void setMessage(final String message) {
        this.message = message;
    }
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "AssignItemOutDto [message=" + message + "]";
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
        AssignItemOutDto other = (AssignItemOutDto) obj;
        return Objects.equals(message, other.message);
    }
}
