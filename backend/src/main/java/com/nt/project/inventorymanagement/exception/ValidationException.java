package com.nt.project.inventorymanagement.exception;

/**
 * @author Sejal Jain.
 *
 */
public class ValidationException extends RuntimeException {
    /**
     * @param message : msg.
     */
    public ValidationException(final String message) {
        super(message);
    }
}
