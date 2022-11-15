package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserLoginOutDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void UserLoginOutDtoTest() {
        UserLoginOutDto emp =new UserLoginOutDto();
        String role="role";
        String firstName ="sejal";
        String employeeId="N0001";
        boolean firstLogin=false;
        
        emp.setFirstName(firstName);
        emp.setEmployeeId(employeeId);
        emp.setFirstLogin(firstLogin);
        emp.setRole(role);
        
        assertEquals(role,emp.getRole());
        assertEquals(firstName,emp.getFirstName());
        assertEquals(employeeId,emp.getEmployeeId());
        assertEquals(firstLogin,emp.isFirstLogin());
        
    }
    @Test
    public void testGettersAndSetters() {
        UserLoginOutDto emp =new UserLoginOutDto();
      
        assertNull(emp.getRole());
        String role="role";
        emp.setRole(role);
        assertEquals(role, emp.getRole());
        
        assertNull(emp.getFirstName());
        String firstName ="sejal";
        emp.setFirstName(firstName);
        assertEquals(firstName, emp.getFirstName());
        
        assertNull(emp.getEmployeeId());
        String employeeId="N0001";
        emp.setEmployeeId(employeeId);
        assertEquals(employeeId, emp.getEmployeeId());
        
        
        boolean firstLogin=false;
        emp.setFirstLogin(firstLogin);
        assertEquals(firstLogin, emp.isFirstLogin());
        
        
    }
    @Test
    public void testToString() {
        
        String  employeeId = "111";
        String firstName = "firstname";
        String role = "role";
        boolean firstLogin =false;
        UserLoginOutDto assetDto = buildUserDto(employeeId,firstName,role,firstLogin);
        assertNotNull(assetDto.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
           
        String  employeeId = "111";
        String firstName = "firstname";
        String role = "role";
        boolean firstLogin =false;
        
        UserLoginOutDto emp = buildUserDto(employeeId,firstName,role,firstLogin);
        UserLoginOutDto emp1 = buildUserDto(employeeId,firstName,role,firstLogin);
        
        assertEquals(emp, emp1);
        assertEquals(emp, emp);
        assertEquals(false, emp.equals(null));
        System.out.println(emp.toString().hashCode());
        System.out.println(emp1.toString().hashCode());
        assertEquals(emp.hashCode(),emp1.hashCode());
    }
    
    public UserLoginOutDto buildUserDto(String employeeId,String firstName,String role,boolean firstLogin) {
        UserLoginOutDto userInDto = new UserLoginOutDto();
        userInDto.setEmployeeId(employeeId);
        userInDto.setFirstName(firstName);
        userInDto.setRole(role);
        userInDto.setFirstLogin(firstLogin);
        return userInDto;
    }
   
}
