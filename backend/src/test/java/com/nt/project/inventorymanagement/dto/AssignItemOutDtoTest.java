package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class AssignItemOutDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void AssignItemOutDtoTest() {
        AssignItemOutDto assign =new AssignItemOutDto();
        String msg = "Message";
        
        assign.setMessage(msg);
        
        assertEquals(msg,assign.getMessage());
    }
    @Test
    public void testGettersAndSetters() {
        AssignItemOutDto assign =new AssignItemOutDto();
        assertNull(assign.getMessage());
        String msg = "Message";
    	
        assign.setMessage(msg);
    	assertEquals(msg, assign.getMessage());
    	
    	
    }
    @Test
    public void testToString() {
        
        String msg = "Message";
        AssignItemOutDto assign = new AssignItemOutDto();
        assign.setMessage(msg);
        
        assertNotNull(assign.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
    	   
        String msg = "Message";
        
        AssignItemOutDto assign = new AssignItemOutDto();
        assign.setMessage(msg);
        AssignItemOutDto assign1 = new AssignItemOutDto();
        assign1.setMessage(msg);
        assertEquals(assign, assign1);
        assertEquals(assign, assign);
        assertEquals(false, assign.equals(null));
        System.out.println(assign.toString().hashCode());
        System.out.println(assign1.toString().hashCode());
        assertEquals(assign.hashCode(),assign1.hashCode());
    }
   
}
