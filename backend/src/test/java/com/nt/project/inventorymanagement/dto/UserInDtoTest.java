package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserInDtoTest{
    /**
     * To test the userDto class.
     */
    @Test
    public void userInDtoTest() {
        UserInDto user =new UserInDto();
        int Id = 6;
        String employeeId = "111";
        String firstName = "Sejal";
        String lastName = "Jain";
        String email ="sejal@gmail.com";
        String dateOfBirth ="07/12/1999";
        String phoneNo = "9752835297";
        String password = "sejal";
        String desiganation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setDateOfJoining(dateOfJoining);
        user.setEmployeeId(employeeId);
        user.setPassword(password);
        user.setPhoneNo(phoneNo);
        user.setDesiganation(desiganation);
        user.setId(Id);
        user.setRole(role);
        
        assertEquals(email,user.getEmail());
        assertEquals(firstName,user.getFirstName());
        assertEquals(lastName,user.getLastName());
        assertEquals(password,user.getPassword());
        assertEquals(Id,user.getId());
        assertEquals(employeeId,user.getEmployeeId());
        assertEquals(phoneNo,user.getPhoneNo());
        assertEquals(desiganation,user.getDesiganation());
        assertEquals(dateOfJoining,user.getDateOfJoining());
        assertEquals(dateOfBirth,user.getDateOfBirth());
        assertEquals(role,user.getRole());
        
    }
    @Test
    public void testGettersAndSetters() {
    	UserInDto userInDto =new UserInDto();
    	

    	assertNull(userInDto.getFirstName());
        String firstName = "firstName";
        userInDto.setFirstName(firstName);
        assertEquals(firstName, userInDto.getFirstName()); 
        

    	assertNull(userInDto.getLastName());
        String lastName = "lastName";
        userInDto.setLastName(lastName);
        assertEquals(lastName, userInDto.getLastName());
    	
    	assertNull(userInDto.getEmail());
    	String email = "email";
    	userInDto.setEmail(email);
    	assertEquals(email, userInDto.getEmail());
    	
    	assertNull(userInDto.getPassword());
    	String password = "password";
    	userInDto.setPassword(password);
    	assertEquals(password, userInDto.getPassword());
    	
    	assertNull(userInDto.getPhoneNo());
    	String phoneNo = "phoneNo";
    	userInDto.setPhoneNo(phoneNo);
    	assertEquals(phoneNo, userInDto.getPhoneNo());
    	
    	assertNull(userInDto.getDesiganation());
    	String desiganation = "desiganation";
    	userInDto.setDesiganation(desiganation);
    	assertEquals(desiganation, userInDto.getDesiganation());
    	
    	assertNull(userInDto.getDateOfBirth());
    	String dateOfBirth = "dateOfBirth";
    	userInDto.setDateOfBirth(dateOfBirth);
    	assertEquals(dateOfBirth, userInDto.getDateOfBirth());
    	
    	assertNull(userInDto.getDateOfJoining());
    	String dateOfJoining = "dateOfJoining";
    	userInDto.setDateOfJoining(dateOfJoining);
    	assertEquals(dateOfJoining, userInDto.getDateOfJoining());
    	
    	assertNull(userInDto.getEmployeeId());
    	String employeeId = "111";
    	userInDto.setEmployeeId(employeeId);
    	assertEquals(employeeId, userInDto.getEmployeeId());
    	
    	
        assertNull(userInDto.getRole());
        String role = "role";
        userInDto.setRole(role);
        assertEquals(role, userInDto.getRole());
    }
    @Test
    public void testToString() {
        int userId = 6;
        String  employeeId = "111";
        String firstName = "firstname";
        String lastName = "lastname";
        String email ="email@email.com";
        String dateOfBirth ="daateOfBirth";
        String phoneNo = "phoneNo";
        String password = "password";
        String desiganation = "desiganation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        UserInDto userInDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,password,desiganation,dateOfJoining,role);
        assertNotNull(userInDto.toString());
        System.out.println(userInDto.toString());
//        assertEquals(,userDto.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
    	   
        int userId = 6;
        String employeeId = "111";
        String firstName = "firstname";
        String lastName = "lastname";
        String email ="email@email.com";
        String dateOfBirth ="daateOfBirth";
        String phoneNo = "phoneNo";
        String password = "password";
        String desiganation = "desiganation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        UserInDto userInDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,password,desiganation,dateOfJoining,role);
        UserInDto userDto1 = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,password,desiganation,dateOfJoining,role);
        assertEquals(userInDto, userDto1);
        assertEquals(userInDto, userInDto);
        assertEquals(false, userInDto.equals(null));
        System.out.println(userInDto.toString().hashCode());
        System.out.println(userDto1.toString().hashCode());
        assertEquals(userInDto.hashCode(),userDto1.hashCode());
    }
    public UserInDto buildUserDto(int userId,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNo,String password,String desiganation,String dateOfJoining,String role) {
        UserInDto userInDto = new UserInDto();
        userInDto.setId(userId);
        userInDto.setEmployeeId(employeeId);
        userInDto.setFirstName(firstName);
        userInDto.setLastName(firstName);
        userInDto.setEmail(email);
        userInDto.setDateOfBirth(dateOfBirth);
        userInDto.setPhoneNo(phoneNo);
        userInDto.setPassword(password);
        userInDto.setDesiganation(desiganation);
        userInDto.setDateOfJoining(dateOfJoining);
        
        userInDto.setRole(role);
        return userInDto;
    }
}
