package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ItemOutDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void ItemOutDtoTest() {
        ItemOutDto emp =new ItemOutDto();
        String msg = "Message";
        
        emp.setMessage(msg);
        
        assertEquals(msg,emp.getMessage());
    }
    @Test
    public void testGettersAndSetters() {
        ItemOutDto emp =new ItemOutDto();
        assertNull(emp.getMessage());
        String msg = "Message";
        
        emp.setMessage(msg);
        
        assertEquals(msg, emp.getMessage());
        
        
    }
    @Test
    public void testToString() {
        
        String msg = "Message";
        ItemOutDto emp =new ItemOutDto();
        emp.setMessage(msg);
        
        assertNotNull(emp.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
           
        String msg = "Message";
        
        ItemOutDto emp =new ItemOutDto();
        emp.setMessage(msg);
        ItemOutDto emp1 =new ItemOutDto();
        emp1.setMessage(msg);
        assertEquals(emp, emp1);
        assertEquals(emp, emp);
        assertEquals(false, emp.equals(null));
        System.out.println(emp.toString().hashCode());
        System.out.println(emp1.toString().hashCode());
        assertEquals(emp.hashCode(),emp1.hashCode());
    }
   
}
