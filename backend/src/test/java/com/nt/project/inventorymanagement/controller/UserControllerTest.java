package com.nt.project.inventorymanagement.controller;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.project.inventorymanagement.dto.ResetPwdOutDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserLoginInDto;
import com.nt.project.inventorymanagement.dto.UserLoginOutDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;
import com.nt.project.inventorymanagement.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
@MockitoSettings(strictness = Strictness.LENIENT) 
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    

    @Autowired
    @Mock
     private UserService userService;
    
     
     @Autowired
     private MockMvc mockMvc;

     
     @InjectMocks
     UserController userController;

     
     @BeforeEach
     public void setup() {
         mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
     }
     

     @Test
     public void createUsertest() throws Exception{
         UserOutDto outDto= new UserOutDto();
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "firstname";
         String lastName = "lastName";
         String email ="email@nucleusteq.com";
         String dateOfBirth ="dateOfBirth";
         String phoneNumber = "7232890902";
         String password = "password";
         String desiganation = "designation";
         String dateOfJoining = "dateOfJoining";
         String role = "role";
         String dateOfExit = "dateOfExit";
         String location = "location";
         String message="Registration Successfull";
         
         outDto.setMessage(message);

         UserInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,desiganation,dateOfJoining,role,dateOfExit,location);
         Mockito.when(userService.createUser(userDto)).thenReturn(outDto);
         
           ObjectMapper objectMapper = new ObjectMapper();
           String inputJSON = objectMapper.writeValueAsString(userDto);
          
           MvcResult mvcResult = this.mockMvc.perform(post("/user/register")
                   .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
           int status = mvcResult.getResponse().getStatus();
           assertEquals(200, status);
     }
     @Test
     public void createUserNegativeTest() throws Exception {
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "firstname";
         String lastName = "lastName";
         String email ="email@email.com";
         String dateOfBirth ="dateOfBirth";
         String phoneNumber = "phoneNumber";
         String password = "password";
         String desiganation = "designation";
         String dateOfJoining = "dateOfJoining";
         String role = "role";
         String dateOfExit = "dateOfExit";
         String location = "location";
         UserInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,desiganation,dateOfJoining,role,dateOfExit,location);
          Mockito.when(userService.createUser(userDto)).thenReturn(null);
         
           ObjectMapper objectMapper = new ObjectMapper();
           String inputJSON = objectMapper.writeValueAsString(userDto);
          
           MvcResult mvcResult = this.mockMvc.perform(post("/user/register")
                   .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
           int status = mvcResult.getResponse().getStatus();
           assertEquals(400, status);
     }

     @Test
     public void loginTest() throws Exception {
         MockitoAnnotations.openMocks(this);
         String email="email@nucleusteq.com";
         String password="password";
         String firstName="sejal"; 
         String role ="employee";
         String employeeId ="N0001";
         boolean firstLogin  = false;
         
         UserLoginInDto loginDtoIn = new UserLoginInDto(email, password);
         UserLoginOutDto loginDtoOut = new UserLoginOutDto(role,firstName,employeeId,firstLogin);
         //System.out.println(">>>>>>"+userService.login(loginDtoIn));
         System.out.println(loginDtoIn);
         System.out.println(loginDtoOut);
         
         Mockito.when(userService.login(loginDtoIn)).thenReturn(loginDtoOut);
         
            
                   ObjectMapper objectMapper = new ObjectMapper();
                   String inputJSON = objectMapper.writeValueAsString(loginDtoIn);
                  
                   MvcResult mvcResult = this.mockMvc.perform(post("/user/login")
                           .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
                   int status = mvcResult.getResponse().getStatus();
                   assertEquals(200, status);        
     }
     @Test
     public void loginNegativeTest() throws Exception {
         MockitoAnnotations.openMocks(this);
         String email="email@nucleusteq.com";
         String password="password";
     
         UserLoginInDto loginDtoIn = new UserLoginInDto(email, password);
         UserLoginOutDto loginDtoOut = new UserLoginOutDto(null,null);
         
          Mockito.when(userService.login(loginDtoIn)).thenReturn(loginDtoOut);
                   ObjectMapper objectMapper = new ObjectMapper();
                   String inputJSON = objectMapper.writeValueAsString(loginDtoIn);
                   MvcResult mvcResult = this.mockMvc.perform(post("/user/login")
                           .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
                   int status = mvcResult.getResponse().getStatus();
                   assertEquals(400, status);        
     }
     @Test
     public void resetTest()throws Exception{
         MockitoAnnotations.openMocks(this);
         String email ="email@nucleusteq.com";
         String password ="password";
         
         UserLoginInDto userDto= new  UserLoginInDto(email,password);
         ResetPwdOutDto pwdOutDto = new ResetPwdOutDto();
         
         Mockito.when(userService.resetPassword(userDto)).thenReturn(pwdOutDto);
                 ObjectMapper objectMapper = new ObjectMapper();
                 String inputJson =objectMapper.writeValueAsString(userDto);
                 MvcResult mvcResult = this.mockMvc.perform(put("/user/reset")
                         .contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
                 int status = mvcResult.getResponse().getStatus();
                 assertEquals(200, status);
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
