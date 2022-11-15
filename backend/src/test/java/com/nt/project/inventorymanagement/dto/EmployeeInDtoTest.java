package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeInDtoTest {

    @Test
    void EmployeeInDtoTest() {
        UserInDto user =new UserInDto();
        int userId = 6;
        String employeeId = "111";
        String firstName = "Sejal";
        String lastName = "Jain";
        String email ="sejal@gmail.com";
        String dateOfBirth ="07/12/1999";
        String phoneNo = "9752835297";
        String desiganation = "developer";
        String dateOfJoining = "11/05/2022";
        String dateOfExit = "11/07/2022";
        String role = "Employee";
        
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setDateOfJoining(dateOfJoining);
        user.setDateOfExit(dateOfExit);
        user.setEmployeeId(employeeId);
        user.setPhoneNo(phoneNo);
        user.setDesiganation(desiganation);
        user.setId(userId);
        user.setRole(role);
        
        assertEquals(email,user.getEmail());
        assertEquals(firstName,user.getFirstName());
        assertEquals(lastName,user.getLastName());
        assertEquals(dateOfExit,user.getDateOfExit());
        assertEquals(userId,user.getId());
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
        
        assertNull(userInDto.getDateOfExit());
        String dateOfExit = "dateOfExit";
        userInDto.setDateOfExit(dateOfExit);
        assertEquals(dateOfExit, userInDto.getDateOfExit());
        
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
        String dateOfExit = "12/08/2022";
        String desiganation = "desiganation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        EmployeeInDto userInDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,dateOfExit,desiganation,dateOfJoining,role);
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
        String dateOfExit = "dateOfExit";
        String desiganation = "desiganation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        EmployeeInDto userInDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,dateOfExit,desiganation,dateOfJoining,role);
        EmployeeInDto userDto1 = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,dateOfExit,desiganation,dateOfJoining,role);
        assertEquals(userInDto, userDto1);
        assertEquals(userInDto, userInDto);
        assertEquals(false, userInDto.equals(null));
        System.out.println(userInDto.toString().hashCode());
        System.out.println(userDto1.toString().hashCode());
        assertEquals(userInDto.hashCode(),userDto1.hashCode());
    }
    public EmployeeInDto buildUserDto(int userId,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNo,String dateOfExit,String desiganation,String dateOfJoining,String role) {
        EmployeeInDto userInDto = new EmployeeInDto();
        userInDto.setUserId(userId);
        userInDto.setEmployeeId(employeeId);
        userInDto.setFirstName(firstName);
        userInDto.setLastName(firstName);
        userInDto.setEmail(email);
        userInDto.setDateOfBirth(dateOfBirth);
        userInDto.setPhoneNo(phoneNo);
        userInDto.setDateOfExit(dateOfExit);
        userInDto.setDesiganation(desiganation);
        userInDto.setDateOfJoining(dateOfJoining);
        
        userInDto.setRole(role);
        return userInDto;
    }

}