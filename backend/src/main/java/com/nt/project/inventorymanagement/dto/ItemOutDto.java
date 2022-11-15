package com.nt.project.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Sejal Jain
 *
 */
public  final class ItemOutDto {
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
     * super constructor.
     */
    public ItemOutDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * to string.
     */
    @Override
    public String toString() {
        return "ItemOutDto [message=" + message + "]";
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
        ItemOutDto other = (ItemOutDto) obj;
        return Objects.equals(message, other.message);
    }
}
