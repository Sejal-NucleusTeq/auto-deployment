package com.nt.project.inventorymanagement.service.impl;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.nt.project.inventorymanagement.controller.UserController;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.ResetPwdOutDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserLoginInDto;
import com.nt.project.inventorymanagement.dto.UserLoginOutDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;
import com.nt.project.inventorymanagement.exception.ValidationException;
import com.nt.project.inventorymanagement.repository.UserRepository;
import com.nt.project.inventorymanagement.service.UserService;
@RunWith(SpringRunner.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserService userService;
    @Mock
    UserController userController;
  
    @BeforeEach
    public void buildUserDto(){
        MockitoAnnotations.openMocks(this);
    
    }
    
    
    @DisplayName("JUnit test for register method")
    @Test
    public void createUserTest() {
        MockitoAnnotations.openMocks(this);
        int id = 6;
        String employeeId = "N0001";
        String firstName = "sejal";
        String lastName = "jain";
        String email ="sejal@nucleusteq.com";
        String dateOfBirth ="07/12/1999";
        String phoneNumber = "9752835297";
        String password = "sejal";
        String designation = "developer";
        String dateOfJoining = "18/07/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        String message="Registration Successfull";
        UserOutDto outDto = new UserOutDto();
        outDto.setMessage(message);
        UserInDto userDto = buildUserDto(id, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
        User user = new User();
        user.setEmployeeId(userDto.getEmployeeId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setDateOfJoining(userDto.getDateOfJoining());
        user.setPassword(userDto.getPassword());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setDesiganation(userDto.getDesiganation());
        user.setRole(userDto.getRole());
        user.setDateOfExit(userDto.getDateOfExit());
        user.setLocation(userDto.getLocation());
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(outDto,userServiceImpl.createUser(userDto));
    }
    
    @Test
    public void loginTest(){
        int userId = 6;
        String employeeId = "N0001";
        String firstName = "sejal";
        String lastName = "jain";
        String email ="sejal@nucleusteq.com";
        String dateOfBirth ="07/12/1999";
        String phoneNumber = "9752835297";
        String password = "sejal";
        String designation = "developer";
        String dateOfJoining = "18/07/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        boolean firstLogin = false;
        
        
        MockitoAnnotations.openMocks(this);
        User user = new User(userId,firstName,email,phoneNumber,password,role,employeeId,designation,firstLogin);
        UserLoginInDto loginDtoIn = new UserLoginInDto("sejal@nucleusteq.com","sejal");
        Optional<User> optUser = Optional.of(user);
        
        UserLoginOutDto loginDtoOut= new UserLoginOutDto();
        loginDtoOut.setFirstName(user.getFirstName());
        loginDtoOut.setRole(user.getRole());
        loginDtoOut.setEmployeeId(user.getEmployeeId());
        loginDtoOut.setFirstLogin(false);
        
        Mockito.when(userRepository.findByEmailAndPassword(email,password)).thenReturn(optUser);
   //     Mockito.when(userRepository.save(user)).thenReturn(user);
        
         assertEquals(loginDtoOut, userServiceImpl.login(loginDtoIn));
    }
    
    @Test
    public void loginNegativeTest() {
        
        String email ="sejal@nucleusteq.com";
       
        String password = "sejal";
        
        MockitoAnnotations.openMocks(this);
       
        UserLoginInDto loginDtoIn = new UserLoginInDto("sejal@nucleusteq.com"," ");
        
        
        User user = new User();
        Optional<User> optUser = Optional.of(user); 
        
        
        Mockito.when(userRepository.findByEmailAndPassword(email,password)).thenReturn(optUser);
        
     // assertEquals(null, userService.login(loginDtoIn));
        ValidationException validationException = assertThrows(ValidationException.class,
                ()-> userServiceImpl.login(loginDtoIn));
        assertEquals("Login Failed", validationException.getMessage());
    }
    @Test
    public void resetPasswordTest() {
        
        String email ="sejal@nucleusteq.com";
        
        String password = "sejal";
        String confirmPassword ="sejal123";
        
        String message= "Password reset successfully";
         
        MockitoAnnotations.openMocks(this);
        UserLoginInDto userInDto = new UserLoginInDto(email,password);
        
         User user = new User();
         user.setEmail(userInDto.getEmail());
         user.setPassword(userInDto.getPassword());
         
         Optional<User> optUser = Optional.of(user); 
         ResetPwdOutDto userDtoOut = new ResetPwdOutDto();
        
        when(userRepository.findByEmail(email)).thenReturn(optUser);
        user.setPassword(confirmPassword);
        userDtoOut.setMessage(message);
        
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(userDtoOut, userServiceImpl.resetPassword(userInDto));
    }
    @Test()
    public void resetPasswordNegativeTest()  {
        
        MockitoAnnotations.openMocks(this);
        UserLoginInDto userInDto = new UserLoginInDto("","123456789");
        User user = new User();
        Optional<User> optUser = Optional.empty(); 
        System.out.println(Optional.of(user));
         
        when(userRepository.findByEmail(userInDto.getEmail())).thenReturn(optUser);
        
        ValidationException validationException = assertThrows(
                ValidationException.class, () -> {
                    userServiceImpl.resetPassword(userInDto);
                }
        );
        assertEquals("User doesn't exist", validationException.getMessage());
    }
    
    public UserInDto buildUserDto(int id,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNumber,String password,String designation,String dateOfJoining,String role,String dateOfExit,String location) {
        UserInDto userDto = new UserInDto();
        userDto.setId(id);
        userDto.setEmployeeId(employeeId);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setDateOfBirth(dateOfBirth);
        userDto.setPhoneNo(phoneNumber);
        userDto.setPassword(password);
        userDto.setDesiganation(designation);
        userDto.setDateOfJoining(dateOfJoining);
        userDto.setRole(role);
        userDto.setDateOfExit(dateOfExit);
        userDto.setLocation(location);
        return userDto;
     
    }

    
}
