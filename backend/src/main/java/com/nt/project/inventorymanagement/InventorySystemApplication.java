package com.nt.project.inventorymanagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sejal Jain
 */
@SpringBootApplication
public class InventorySystemApplication {
    /**
     * Constructor.
     */
    protected InventorySystemApplication() {
    }
    /**
     * @param args args.
     */
    public static void main(final String[] args) {
        SpringApplication.run(InventorySystemApplication.class, args);
    }
}
