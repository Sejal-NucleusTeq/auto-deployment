package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ResetPwdInDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void ResetPwdInDtoTest() {
        ResetPwdInDto user =new ResetPwdInDto();
        String password = "sejal";
        String confirmPassword ="sejalnew";
        
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
        
        
        assertEquals(password,user.getPassword());
        assertEquals(confirmPassword, user.getConfirmPassword());
    }
    @Test
    public void testGettersAndSetters() {
        ResetPwdInDto user =new ResetPwdInDto();
    	
    	assertNull(user.getPassword());
    	String password = "password";
    	user.setPassword(password);
    	assertEquals(password, user.getPassword());
    	
    	assertNull(user.getConfirmPassword());
    	 String confirmPassword ="sejalnew";
        user.setConfirmPassword(confirmPassword);
        assertEquals(confirmPassword, user.getConfirmPassword());
    }
    @Test
    public void testToString() {
        
        String password = "password";
        String confirmPassword ="sejalnew";
        
        ResetPwdInDto userInDto = buildUserDto(password,confirmPassword);
        assertNotNull(userInDto.toString());
        System.out.println(userInDto.toString());
//        assertEquals(,userDto.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
    	   
        String password = "password";
        String confirmPassword ="sejalnew";
        
        ResetPwdInDto userInDto = buildUserDto(password ,confirmPassword);
        ResetPwdInDto userInDto1 = buildUserDto(password , confirmPassword);
        assertEquals(userInDto, userInDto1);
        assertEquals(userInDto, userInDto);
        assertEquals(false, userInDto.equals(null));
        System.out.println(userInDto.toString().hashCode());
        System.out.println(userInDto1.toString().hashCode());
        assertEquals(userInDto.hashCode(),userInDto1.hashCode());
    }
    public ResetPwdInDto buildUserDto(String pwd, String cpwd) {
        ResetPwdInDto userInDto = new ResetPwdInDto();
        userInDto.setPassword(pwd);
        userInDto.setConfirmPassword(cpwd);
        return userInDto;
    }
}
