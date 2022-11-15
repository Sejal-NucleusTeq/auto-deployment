package com.nt.project.inventorymanagement.service.impl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.nt.project.inventorymanagement.domain.Item;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.EmployeeInDto;
import com.nt.project.inventorymanagement.dto.EmployeeOutDto;
import com.nt.project.inventorymanagement.dto.ItemInDto;
import com.nt.project.inventorymanagement.dto.ItemOutDto;
import com.nt.project.inventorymanagement.dto.UpdateEmployeeInDto;
import com.nt.project.inventorymanagement.dto.UpdateItemInDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;
import com.nt.project.inventorymanagement.exception.ValidationException;
import com.nt.project.inventorymanagement.repository.ItemRepository;
import com.nt.project.inventorymanagement.repository.UserRepository;
import com.nt.project.inventorymanagement.service.AdminService;
@RunWith(SpringRunner.class)
class AdminServiceImplTest {

    @Mock
    private ItemRepository itemRepository;
    @Mock
    private UserRepository userRepository;
    
    @Mock
    private AdminService adminService;
    
    @InjectMocks
    private  AdminServiceImpl adminServiceImpl;
    
    @BeforeEach
    public void buildUserDto(){
        MockitoAnnotations.openMocks(this);
    
    }
     @Test
     public void addAssetTest() {
         MockitoAnnotations.openMocks(this);
         int itemId = 1;
         String itemName = "itemName";
         String itemNumber = "itemNumber";
         String itemType = "itemType";
         String dateOfPurchase = "dateOfPurchase";
         String itemWarrantyPeriod = "itemWarrantyPeriod";
         String itemLocation = "itemLocation";
         String itemCondition = "itemCondition";
         boolean isItemAssigned =true;
         String incidentsIfAny = "incidentsIfAny";
         
         ItemOutDto itemDtoOut = new ItemOutDto();
         
         ItemInDto itemDto = buildItemDto(itemId, itemName,itemNumber,itemType,dateOfPurchase,itemWarrantyPeriod,itemLocation,itemCondition,isItemAssigned,incidentsIfAny);
         
         Item item = new Item();
         item.setItemId(itemDto.getItemId());
         item.setAssetName(itemDto.getAssetName());
         item.setAssetNo(itemDto.getAssetNo());
         item.setAssetType(itemDto.getAssetType());
         item.setdateOfPurchase(itemDto.getDop());
         item.setWarrantyPeriod(itemDto.getWarrantyPeriod());
         item.setAssetLocation(itemDto.getAssetLocation());
         item.setWorkingStatus(itemDto.getWorkingStatus());
         item.setassignStatus(itemDto.isAssignStatus());
         item.setIncidents(itemDto.getIncidents());
         
         itemDtoOut.setMessage("Item added Successfully");
         Mockito.when(itemRepository.save(item)).thenReturn(item);       
         assertEquals(itemDtoOut,adminServiceImpl.addAsset(itemDto));
     }
     @Test
     public void assAssetNegativeTest() {
         MockitoAnnotations.openMocks(this);
         int itemId = 1;
         String itemName = "itemName";
         String itemNumber = "itemNumber";
         String itemType = "itemType";
         String dateOfPurchase = "dateOfPurchase";
         String itemWarrantyPeriod = "itemWarrantyPeriod";
         String itemLocation = "itemLocation";
         String itemCondition = "itemCondition";
         boolean isItemAssigned =true;
         String incidentsIfAny = "incidentsIfAny";
         
         
         ItemInDto itemDto = buildItemDto(itemId, itemName,itemNumber,itemType,dateOfPurchase,itemWarrantyPeriod,itemLocation,itemCondition,isItemAssigned,incidentsIfAny);
         
         Item item = new Item();
         item.setItemId(itemDto.getItemId());
         item.setAssetName(itemDto.getAssetName());
         item.setAssetNo(itemDto.getAssetNo());
         item.setAssetType(itemDto.getAssetType());
         item.setdateOfPurchase(itemDto.getDop());
         item.setWarrantyPeriod(itemDto.getWarrantyPeriod());
         item.setAssetLocation(itemDto.getAssetLocation());
         item.setWorkingStatus(itemDto.getWorkingStatus());
         item.setassignStatus(itemDto.isAssignStatus());
         item.setIncidents(itemDto.getIncidents());
         
         Optional<Item> optItem = Optional.of(item); 
         
         
         Mockito.when(itemRepository.findByAssetNo(itemNumber)).thenReturn(optItem);
         
      // assertEquals(null, userService.login(loginDtoIn));
         ValidationException validationException = assertThrows(ValidationException.class,
                 ()-> adminServiceImpl.addAsset(itemDto));
         assertEquals("Item Already Exist", validationException.getMessage());  
     }
     
     @Test
     public void addEmployeeTest() {
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "sejal";
         String lastName = "jain";
         String email ="sejal@gmail.com";
         String dateOfBirth ="07/121999";
         String phoneNo = "9898707098";
         String desiganation = "developer";
         String dateOfJoining = "18/07/2022";
         String role = "Admin";
         String dateOfExit = "dateOfExit";
         String location = "location"; 
         
         EmployeeInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,desiganation,dateOfJoining,role,dateOfExit,location);
         EmployeeOutDto usetOutDto = new EmployeeOutDto();
         User user = new User();
          user.setEmployeeId(userDto.getEmployeeId());
          user.setFirstName(userDto.getFirstName());
          user.setLastName(userDto.getLastName());
          user.setEmail(userDto.getEmail());
          user.setDateOfBirth(userDto.getDateOfBirth());
          user.setDateOfJoining(userDto.getDateOfJoining());
          user.setPhoneNo(userDto.getPhoneNo());
          user.setDesiganation(userDto.getDesiganation());
          user.setRole(userDto.getRole());
          user.setDateOfExit(userDto.getDateOfExit());
          user.setLocation(userDto.getLocation());
          usetOutDto.setMessage("Employee added successfully");
          
          Mockito.when(userRepository.save(user)).thenReturn(user);       
          assertEquals(usetOutDto,adminServiceImpl.addEmployee(userDto));
      }
     @Test
     public void addEmployeeNegativeTest1() {
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "sejal";
         String lastName = "jain";
         String email ="sejal@gmail.com";
         String dateOfBirth ="07/121999";
         String phoneNo = "9898707098";
         String desiganation = "developer";
         String dateOfJoining = "18/07/2022";
         String role = "Admin";
         String dateOfExit = "dateOfExit";
         String location = "location"; 
         
         EmployeeInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,desiganation,dateOfJoining,role,dateOfExit,location);
        
         User user = new User();
          user.setEmployeeId(userDto.getEmployeeId());
          user.setFirstName(userDto.getFirstName());
          user.setLastName(userDto.getLastName());
          user.setEmail(userDto.getEmail());
          user.setDateOfBirth(userDto.getDateOfBirth());
          user.setDateOfJoining(userDto.getDateOfJoining());
          user.setPhoneNo(userDto.getPhoneNo());
          user.setDesiganation(userDto.getDesiganation());
          user.setRole(userDto.getRole());
          user.setDateOfExit(userDto.getDateOfExit());
          user.setLocation(userDto.getLocation());
          
          Optional<User> optUser = Optional.of(user); 
          
          
          Mockito.when(userRepository.findByEmail(email)).thenReturn(optUser);
          
          ValidationException validationException = assertThrows(ValidationException.class,
                  ()-> adminServiceImpl.addEmployee(userDto));
          assertEquals("Email Already Exist", validationException.getMessage());  
      }
     @Test
     public void addEmployeeNegativeTest2() {
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "sejal";
         String lastName = "jain";
         String email ="sejal@gmail.com";
         String dateOfBirth ="07/121999";
         String phoneNo = "9898707098";
         String desiganation = "developer";
         String dateOfJoining = "18/07/2022";
         String role = "Admin";
         String dateOfExit = "dateOfExit";
         String location = "location"; 
         
         EmployeeInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,desiganation,dateOfJoining,role,dateOfExit,location);
        
         User user = new User();
          user.setEmployeeId(userDto.getEmployeeId());
          user.setFirstName(userDto.getFirstName());
          user.setLastName(userDto.getLastName());
          user.setEmail(userDto.getEmail());
          user.setDateOfBirth(userDto.getDateOfBirth());
          user.setDateOfJoining(userDto.getDateOfJoining());
          user.setPhoneNo(userDto.getPhoneNo());
          user.setDesiganation(userDto.getDesiganation());
          user.setRole(userDto.getRole());
          user.setDateOfExit(userDto.getDateOfExit());
          user.setLocation(userDto.getLocation());
          
          Optional<User> optUser = Optional.of(user); 
          
          
          Mockito.when(userRepository.findByEmployeeId(employeeId)).thenReturn(optUser);
          
          ValidationException validationException = assertThrows(ValidationException.class,
                  ()-> adminServiceImpl.addEmployee(userDto));
          assertEquals("EmployeeId Already Exist", validationException.getMessage());  
      } 
     
     @Test
     public void addEmployeeNegativeTest3() {
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "sejal";
         String lastName = "jain";
         String email ="sejal@gmail.com";
         String dateOfBirth ="07/121999";
         String phoneNo = "9898707098";
         String desiganation = "developer";
         String dateOfJoining = "18/07/2022";
         String role = "Admin";
         String dateOfExit = "dateOfExit";
         String location = "location"; 
         
         EmployeeInDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNo,desiganation,dateOfJoining,role,dateOfExit,location);
        
         User user = new User();
          user.setEmployeeId(userDto.getEmployeeId());
          user.setFirstName(userDto.getFirstName());
          user.setLastName(userDto.getLastName());
          user.setEmail(userDto.getEmail());
          user.setDateOfBirth(userDto.getDateOfBirth());
          user.setDateOfJoining(userDto.getDateOfJoining());
          user.setPhoneNo(userDto.getPhoneNo());
          user.setDesiganation(userDto.getDesiganation());
          user.setRole(userDto.getRole());
          user.setDateOfExit(userDto.getDateOfExit());
          user.setLocation(userDto.getLocation());
          
          Optional<User> optUser = Optional.of(user); 
          
          
          Mockito.when(userRepository.findByPhoneNo(phoneNo)).thenReturn(optUser);
          
          ValidationException validationException = assertThrows(ValidationException.class,
                  ()-> adminServiceImpl.addEmployee(userDto));
          assertEquals("PhoneNo Already Exist", validationException.getMessage());  
      }
     
     

     @Test
     public void getItemsTest() {
         
         final List<Item> items = new ArrayList<>();
         Item item = new Item();
         item.setAssetNo("Lap001");
         item.setItemId(1);
         item.setAssetName("Laptop");
         item.setdateOfPurchase("12/02/2021");
         item.setIncidents("no");
         item.setassignStatus(false);
         item.setWorkingStatus("working");
         item.setAssetLocation("indore");
         item.setAssetType("hardware");
         item.setWarrantyPeriod("3years");
         
         Item item1 = new Item();
         item1.setAssetNo("Lap002");
         item1.setItemId(1);
         item1.setAssetName("Laptop");
         item1.setdateOfPurchase("12/02/2021");
         item1.setIncidents("no");
         item1.setassignStatus(false);
         item1.setWorkingStatus("working");
         item1.setAssetLocation("indore");
         item1.setAssetType("hardware");
         item1.setWarrantyPeriod("3years");
         
         items.add(item);
         items.add(item1);
         
         List<Item> foundItems = adminServiceImpl.getItems();
         assertNotNull(foundItems);
         assertEquals(2,items.size());
         
     }
     
     @Test
     public void getAllEmployeeTest() {
          MockitoAnnotations.openMocks(this);
          int userId = 6;
          String employeeId = "N0011";
          String firstName = "sejal";
          String lastName = "jain";
          String email ="sejal@gmail.com";
          String dateOfBirth ="07/121999";
          String phoneNo = "9898707098";
          String desiganation = "developer";
          String dateOfJoining = "18/07/2022";
          String role = "Admin";
          String dateOfExit = "dateOfExit";
          String location = "location"; 
          
          User user= new User();
          user.setEmployeeId(employeeId);
          user.setuserId(userId);
          user.setFirstName(firstName);
          user.setLastName(lastName);
          user.setEmail(email);
          user.setDateOfBirth(dateOfBirth);
          user.setPhoneNo(phoneNo);
          user.setDesiganation(desiganation);
          user.setDateOfJoining(dateOfJoining);
          user.setRole(role);
          user.setDateOfExit(dateOfExit);
          user.setLocation(location);
          
         List<User> employeeList = new ArrayList<User>();
         employeeList.add(user);
         when(userRepository.findAll()).thenReturn(employeeList);
         assertEquals(employeeList, adminServiceImpl.getEmployees());
 }

     @Test
     public void updateItemTest(){
         MockitoAnnotations.openMocks(this);
         int itemId = 1;
         String assetName = "itemName";
         String assetNo = "itemNumber";
         String assetType = "itemType";
         String dop = "dateOfPurchase";
         String warrantyPeriod = "itemWarrantyPeriod";
         String assetLocation = "itemLocation";
         String workingStatus = "itemCondition";
         boolean assignStatus =true;
         String incidents = "incidentsIfAny";
         
         ItemOutDto itemDtoOut = new ItemOutDto();
         UpdateItemInDto updateItemDtoIn = new UpdateItemInDto(itemId,assetName,assetNo,assetType,dop,warrantyPeriod,assetLocation,workingStatus,assignStatus,incidents);
         
         Item item = new Item();
         item.setItemId(updateItemDtoIn.getItemId());
         item.setAssetName(updateItemDtoIn.getAssetName());
         item.setAssetType(updateItemDtoIn.getAssetType());
         item.setdateOfPurchase(updateItemDtoIn.getDop());
         item.setWarrantyPeriod(updateItemDtoIn.getWarrantyPeriod());
         item.setAssetLocation(updateItemDtoIn.getAssetLocation());
         item.setWorkingStatus(updateItemDtoIn.getWorkingStatus());
         item.setassignStatus(updateItemDtoIn.isAssignStatus());
         item.setIncidents(updateItemDtoIn.getIncidents());
         Optional<Item> optItem = Optional.of(item);
         when(itemRepository.findByAssetNo(assetNo)).thenReturn(optItem);
         item.setAssetName("Laptop");
         itemDtoOut.setMessage("Item Updated successfully");
         when(itemRepository.save(item)).thenReturn(item);
         assertEquals(itemDtoOut, adminServiceImpl.updateItem(updateItemDtoIn));
     }

     @Test
     public void updateEmployeeTest()  {
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "sejal";
         String lastName = "jain";
         String email ="sejal@gmail.com";
         String dateOfBirth ="07/121999";
         String phoneNo = "9898707098";
         String desiganation = "developer";
         String dateOfJoining = "18/07/2022";
         String role = "Admin";
         String dateOfExit = "dateOfExit";
         String location = "location"; 
         EmployeeOutDto adminDtoOut = new EmployeeOutDto();
         UpdateEmployeeInDto updateDtoIn = new UpdateEmployeeInDto(userId, firstName, lastName,
                  employeeId,  email, dateOfBirth,  phoneNo,
                  desiganation,  dateOfJoining,
                  role);
         User user = new User();
         user.setuserId(updateDtoIn.getUserId());
         user.setFirstName(updateDtoIn.getFirstName());
         user.setLastName(updateDtoIn.getLastName());
         user.setDateOfBirth(updateDtoIn.getDateOfBirth());
         user.setDateOfJoining(updateDtoIn.getDateOfJoining());
         user.setDesiganation(updateDtoIn.getDesiganation());
         user.setRole(updateDtoIn.getRole());
         user.setDateOfExit(updateDtoIn.getDateOfExit());
         user.setLocation(updateDtoIn.getLocation()); 
         Optional<User> optUser = Optional.of(user);
         when(userRepository.findById(userId)).thenReturn(optUser);
         user.setLocation("new Location");
         adminDtoOut.setMessage("Employee Updated successfully");
         when(userRepository.save(user)).thenReturn(user);
         assertEquals(adminDtoOut, adminServiceImpl.updateEmployee(updateDtoIn));
     }
     
     @Test
     public void searchEmployeeDetails() {
         
         MockitoAnnotations.openMocks(this);
         int userId = 6;
         String employeeId = "N0011";
         String firstName = "sejal";
         String lastName = "jain";
         String email ="sejal@gmail.com";
         String dateOfBirth ="07/12/1999";
         String phoneNumber = "9898787890";
         String password = "sejal";
         String designation = "developer";
         String dateOfJoining = "18/07/2022";
         String role = "Admin";
         String dateOfExit = "dateOfExit";
         String location = "location";
         
     }
     
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
     
     public EmployeeInDto buildUserDto(int userId,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNumber,String designation,String dateOfJoining,String role,String dateOfExit,String location) {
         EmployeeInDto userDto = new EmployeeInDto();
         userDto.setUserId(userId);
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

}
