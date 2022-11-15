package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class EmployeeOutDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void EmployeeOutDtoTest() {
        EmployeeOutDto emp =new EmployeeOutDto();
        String msg = "Message";
        
        emp.setMessage(msg);
        
        assertEquals(msg,emp.getMessage());
    }
    @Test
    public void testGettersAndSetters() {
        EmployeeOutDto emp =new EmployeeOutDto();
        assertNull(emp.getMessage());
        String msg = "Message";
        
        emp.setMessage(msg);
        
    	assertEquals(msg, emp.getMessage());
    	
    	
    }
    @Test
    public void testToString() {
        
        String msg = "Message";
        EmployeeOutDto emp =new EmployeeOutDto();
        emp.setMessage(msg);
        
        assertNotNull(emp.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
    	   
        String msg = "Message";
        
        EmployeeOutDto emp =new EmployeeOutDto();
        emp.setMessage(msg);
        EmployeeOutDto emp1 =new EmployeeOutDto();
        emp1.setMessage(msg);
        assertEquals(emp, emp1);
        assertEquals(emp, emp);
        assertEquals(false, emp.equals(null));
        System.out.println(emp.toString().hashCode());
        System.out.println(emp1.toString().hashCode());
        assertEquals(emp.hashCode(),emp1.hashCode());
    }
   
}
