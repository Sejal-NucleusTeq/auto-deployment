package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ResetPwdOutDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void ResetPwdOutDtoTest() {
        ResetPwdOutDto emp =new ResetPwdOutDto();
        String msg = "Message";
        
        emp.setMessage(msg);
        
        assertEquals(msg,emp.getMessage());
    }
    @Test
    public void testGettersAndSetters() {
        ResetPwdOutDto emp =new ResetPwdOutDto();
        assertNull(emp.getMessage());
        String msg = "Message";
        
        emp.setMessage(msg);
        
        assertEquals(msg, emp.getMessage());
        
        
    }
    @Test
    public void testToString() {
        
        String msg = "Message";
        ResetPwdOutDto emp =new ResetPwdOutDto();
        emp.setMessage(msg);
        
        assertNotNull(emp.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
           
        String msg = "Message";
        
        ResetPwdOutDto emp =new ResetPwdOutDto();
        emp.setMessage(msg);
        ResetPwdOutDto emp1 =new ResetPwdOutDto();
        emp1.setMessage(msg);
        assertEquals(emp, emp1);
        assertEquals(emp, emp);
        assertEquals(false, emp.equals(null));
        System.out.println(emp.toString().hashCode());
        System.out.println(emp1.toString().hashCode());
        assertEquals(emp.hashCode(),emp1.hashCode());
    }
   
}
