package com.nt.project.inventorymanagement.exception;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author global exception handler.
 */
@ControllerAdvice
public final class GlobalExceptionHandler {
    /**
     * error code.
     */
    public static final int ERRORCODE = 400;
    /**
     * @param exception : will catch the exception.
     * @return : it will return the exception.
     */
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<Map<String, String>> handleConflict(
            final ValidationException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return ResponseEntity.status(ERRORCODE).body(response);
    }
    /**
     * @param ex : excp.
     * @return : error.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleMethodArgsNotValidException(
            final MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put("message", fieldName + " " + message);
        });
        return new ResponseEntity<Map<String, String>>(
                resp, HttpStatus.BAD_REQUEST);
    }
}
