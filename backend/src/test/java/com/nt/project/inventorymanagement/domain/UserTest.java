
package com.nt.project.inventorymanagement.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Sejal Jain
 *
 */
public class UserTest {

    /**
     * To test the user class
     */
    @Test
    public void userTest() {
        User user =new User();
        int userId = 6;
        String firstName = "sejal";
        String lastName = "jain";
        String  employeeId = "111";
        String email ="sejal@gmail.com";
        String dateOfBirth ="07/12/2000";
        String phoneNo = "7232890902";
        String password = "sejal";
        String desiganation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";

        user.setuserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmployeeId(employeeId);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setDateOfJoining(dateOfJoining);
        user.setEmployeeId(employeeId);
        user.setPassword(password);
        user.setPhoneNo(phoneNo);
        user.setDesiganation(desiganation);
	    user.setRole(role);
	    
	    
	    assertEquals(userId, user.getuserId());
	    assertEquals(firstName,user.getFirstName());
	    assertEquals(lastName,user.getLastName());
	    assertEquals(employeeId,user.getEmployeeId());
		assertEquals(email,user.getEmail());
        assertEquals(password,user.getPassword());
        assertEquals(phoneNo,user.getPhoneNo());
        assertEquals(desiganation,user.getDesiganation());
        assertEquals(dateOfJoining,user.getDateOfJoining());
        assertEquals(dateOfBirth,user.getDateOfBirth());
        assertEquals(role,user.getRole());
        
    }
    
    @Test
    public void testGettersAndSetters() {
    	User user =new User();
    	// assertNull(user.getuserId());
        int userId = 6;
        user.setuserId(userId);
        assertEquals(userId, user.getuserId());
        
        assertNull(user.getFirstName());
    	String firstName = "sejal";
    	user.setFirstName(firstName);
    	assertEquals(firstName, user.getFirstName());
    	
    	
    	assertNull(user.getLastName());
    	String lastName = "jain";
    	user.setLastName(lastName);
    	assertEquals(lastName, user.getLastName());
    	 
    	
    	assertNull(user.getEmail());
    	String email = "email";
    	user.setEmail(email);
    	assertEquals(email, user.getEmail());
    	
    	assertNull(user.getPassword());
    	String password = "password";
    	user.setPassword(password);
    	assertEquals(password, user.getPassword());
    	
    	assertNull(user.getPhoneNo());
    	String phoneNumber = "phoneNumber";
    	user.setPhoneNo(phoneNumber);
    	assertEquals(phoneNumber, user.getPhoneNo());
    	
    	assertNull(user.getDesiganation());
    	String designation = "designation";
    	user.setDesiganation(designation);
    	assertEquals(designation, user.getDesiganation());
    	
    	assertNull(user.getDateOfBirth());
    	String dateOfBirth = "dateOfBirth";
    	user.setDateOfBirth(dateOfBirth);
    	assertEquals(dateOfBirth, user.getDateOfBirth());
    	
    	assertNull(user.getDateOfJoining());
    	String dateOfJoining = "dateOfJoining";
    	user.setDateOfJoining(dateOfJoining);
    	assertEquals(dateOfJoining, user.getDateOfJoining());
    	
    	assertNull(user.getEmployeeId());
    	String employeeId = "111";
    	user.setEmployeeId(employeeId);
    	assertEquals(employeeId, user.getEmployeeId());
    	
        assertNull(user.getRole());
        String role = "role";
        user.setRole(role);
        assertEquals(role, user.getRole());
    
    }
    @Test
    public void testToString() {
 
        int userId = 6;
        String employeeId = "111";
        String firstName = "firstname";
        String lastName = "lastname";
        String email ="email@email.com";
        String dateOfBirth ="daateOfBirth";
        String phoneNo = "phoneNumber";
        String password = "password";
        String desiganation = "designation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        
        User userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,password,desiganation,dateOfJoining,role);
        assertNotNull(userDto.toString());
        System.out.println(userDto.toString());
//        assertEquals(,userDto.toString());
    }
    
    @Test
    public void testEqualsAndHashCode() {
    	
    	User user = new User();
    
        int userId = 6;
        String employeeId = "111";
        String firstName = "firstname";
        String lastName = "lastname";
        String email ="email@email.com";
        String dateOfBirth ="daateOfBirth";
        String phoneNo = "phoneNumber";
        String password = "password";
        String desiganation = "designation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        

        User userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,password,desiganation,dateOfJoining,role);
        User userDto1 = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,password,desiganation,dateOfJoining,role);

        assertEquals(userDto, userDto1);
        assertEquals(false, userDto.equals(null));
        assertEquals(false,userDto.equals(user));
        System.out.println(userDto.toString().hashCode());
        System.out.println(userDto1.toString().hashCode());
        assertEquals(userDto.hashCode(),userDto1.hashCode());
    }
   
    public User buildUserDto(int userId,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNo,String password,String desiganation,String dateOfJoining, String role) {
        User userDto = new User();
        userDto.setuserId(userId);
        userDto.setEmployeeId(employeeId);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setDateOfBirth(dateOfBirth);
        userDto.setPhoneNo(phoneNo);
        userDto.setPassword(password);
        userDto.setDesiganation(desiganation);
        userDto.setDateOfJoining(dateOfJoining);
        userDto.setRole(role);
        return userDto;
     
    }

}
