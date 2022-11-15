package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserLoginInDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void userInDtoTest() {
        UserLoginInDto user =new UserLoginInDto();
        String email ="sejal@gmail.com";
        String password = "sejal";
        user.setEmail(email);
        user.setPassword(password);
        
        assertEquals(email,user.getEmail());
        assertEquals(password,user.getPassword());
    }
    @Test
    public void testGettersAndSetters() {
    	UserInDto userInDto =new UserInDto();
    	
    	assertNull(userInDto.getEmail());
    	String email = "email";
    	userInDto.setEmail(email);
    	assertEquals(email, userInDto.getEmail());
    	
    	assertNull(userInDto.getPassword());
    	String password = "password";
    	userInDto.setPassword(password);
    	assertEquals(password, userInDto.getPassword());
    	
    }
    @Test
    public void testToString() {
        String email ="email@email.com";
        String password = "password";
        UserLoginInDto userInDto = buildUserDto(email ,password);
        assertNotNull(userInDto.toString());
        System.out.println(userInDto.toString());
//        assertEquals(,userDto.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
    	   
        String email ="email@email.com";
        String password = "password";
        
        UserLoginInDto userInDto = buildUserDto(email,password);
        UserLoginInDto userInDto1 = buildUserDto(email,password);
        assertEquals(userInDto, userInDto1);
        assertEquals(userInDto, userInDto);
        assertEquals(false, userInDto.equals(null));
        System.out.println(userInDto.toString().hashCode());
        System.out.println(userInDto1.toString().hashCode());
        assertEquals(userInDto.hashCode(),userInDto1.hashCode());
    }
    public UserLoginInDto buildUserDto(String email, String password) {
        UserLoginInDto userInDto = new UserLoginInDto();
        userInDto.setEmail(email);
        userInDto.setPassword(password);
        return userInDto;
    }
}
