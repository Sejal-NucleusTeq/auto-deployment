package com.nt.project.inventorymanagement.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.project.inventorymanagement.dto.EmployeeInDto;
import com.nt.project.inventorymanagement.dto.EmployeeOutDto;
import com.nt.project.inventorymanagement.dto.ItemInDto;
import com.nt.project.inventorymanagement.dto.ItemOutDto;
import com.nt.project.inventorymanagement.dto.UpdateEmployeeInDto;
import com.nt.project.inventorymanagement.dto.UpdateItemInDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;
import com.nt.project.inventorymanagement.service.AdminService;
@MockitoSettings(strictness = Strictness.LENIENT) 
@ExtendWith(MockitoExtension.class)
class AdminControllerTest {
    @Autowired
    @Mock
    AdminService adminService;
    
    @InjectMocks
    AdminController adminController;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }
    @Test
    public void addAssetTest() throws Exception {
        MockitoAnnotations.openMocks(this);
         
        int itemId = 1;
        String assetName = "itemName";
        String assetNo = "itemNumber";
        String assetType = "itemType";
        String dop = "dateOfPurchase";
        String warrantyPeriod = "itemWarrantyPeriod";
        String assetLocation = "itemLocation";
        String workingStatus = "itemCondition";
        boolean assignStatus =false;
        String incidents = "incidentsIfAny";
        
        
       
        ItemInDto itemDto = buildItemDto(itemId, assetName,assetNo,assetType,dop,warrantyPeriod,assetLocation,workingStatus,assignStatus,incidents);
        ItemOutDto itemDtoOut = new ItemOutDto();
        itemDtoOut.setMessage("Item added Successfully");

        Mockito.when(adminService.addAsset(itemDto)).thenReturn(itemDtoOut);
        
          ObjectMapper objectMapper = new ObjectMapper();
          String inputJSON = objectMapper.writeValueAsString(itemDto);
         
          MvcResult mvcResult = this.mockMvc.perform(post("/inventory/item")
                  .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
          int status = mvcResult.getResponse().getStatus();
          assertEquals(200, status);    
    }
    @Test
    public void addEmployeeTest() throws Exception{
        EmployeeOutDto outDto= new EmployeeOutDto();
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
        String message="Employee added successfully";
        
        outDto.setMessage(message);

        EmployeeInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,desiganation,dateOfJoining,role,dateOfExit,location);
        Mockito.when(adminService.addEmployee(userDto)).thenReturn(outDto);
        
          ObjectMapper objectMapper = new ObjectMapper();
          String inputJSON = objectMapper.writeValueAsString(userDto);
         
          MvcResult mvcResult = this.mockMvc.perform(post("/inventory/employee")
                  .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
          int status = mvcResult.getResponse().getStatus();
          assertEquals(200, status);
    }
    
    
//    @Test
//    public void updateItemTest() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        
//        int itemId = 1;
//        String assetName = "itemName";
//        String assetNo = "itemNumber";
//        String assetType = "itemType";
//        String dop = "dateOfPurchase";
//        String warrantyPeriod = "itemWarrantyPeriod";
//        String assetLocation = "itemLocation";
//        String workingStatus = "itemCondition";
//        boolean assignStatus =false;
//        String incidents = "incidentsIfAny";
//        
//        
//       
//        UpdateItemInDto itemDto = buildItemDto1(itemId, assetName,assetNo,assetType,dop,warrantyPeriod,assetLocation,workingStatus,assignStatus,incidents);
//        ItemOutDto itemDtoOut = new ItemOutDto();
//        itemDtoOut.setMessage("Item updated Successfully");
//
//        Mockito.when(adminService.updateItem(itemDto)).thenReturn(itemDtoOut);
//        
//          ObjectMapper objectMapper = new ObjectMapper();
//          String inputJSON = objectMapper.writeValueAsString(itemDto);
//         
//          MvcResult mvcResult = this.mockMvc.perform(put("/inventory/item")
//                  .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
//          int status = mvcResult.getResponse().getStatus();
//          assertEquals(HttpStatus.OK.value(), status); 
//          }
    
    public ItemInDto buildItemDto(int itemId,String itemName,String itemNumber,String itemType,String dateOfPurchase,String itemWarrantyPeriod,String itemLocation,String itemCondition,boolean isItemAssigned,String incidentsIfAny) {
        ItemInDto itemDto = new ItemInDto();
        itemDto.setItemId(itemId);
        itemDto.setAssetName(itemName);
        itemDto.setAssetNo(itemNumber);
        itemDto.setAssetType(itemType);
        itemDto.setDop(dateOfPurchase);
        itemDto.setWarrantyPeriod(itemWarrantyPeriod);
        itemDto.setAssetLocation(itemLocation);
        itemDto.setWorkingStatus(itemCondition);
        itemDto.setAssignStatus(isItemAssigned);
        itemDto.setIncidents(incidentsIfAny);
        return itemDto;
     
    }
    
    public EmployeeInDto buildUserDto(int id,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNumber,String designation,String dateOfJoining,String role,String dateOfExit,String location) {
        EmployeeInDto userDto = new EmployeeInDto();
        userDto.setUserId(id);
        userDto.setEmployeeId(employeeId);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setDateOfBirth(dateOfBirth);
        userDto.setPhoneNo(phoneNumber);
        userDto.setDesiganation(designation);
        userDto.setDateOfJoining(dateOfJoining);
        userDto.setRole(role);
        userDto.setDateOfExit(dateOfExit);
        userDto.setLocation(location);
        return userDto;
     
    }
//    public UpdateItemInDto buildItemDto1(int itemId,String itemName,String itemNumber,String itemType,String dateOfPurchase,String itemWarrantyPeriod,String itemLocation,String itemCondition,boolean isItemAssigned,String incidentsIfAny) {
//        UpdateItemInDto itemDto = new UpdateItemInDto();
//        itemDto.setItemId(itemId);
//        itemDto.setAssetName(itemName);
//        itemDto.setAssetNo(itemNumber);
//        itemDto.setAssetType(itemType);
//        itemDto.setDop(dateOfPurchase);
//        itemDto.setWarrantyPeriod(itemWarrantyPeriod);
//        itemDto.setAssetLocation(itemLocation);
//        itemDto.setWorkingStatus(itemCondition);
//        itemDto.setAssignStatus(isItemAssigned);
//        itemDto.setIncidents(incidentsIfAny);
//        return itemDto;
//     
//    }



}
