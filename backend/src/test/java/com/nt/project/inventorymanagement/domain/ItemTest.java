package com.nt.project.inventorymanagement.domain;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class ItemTest {
    @BeforeEach
    void setup() {
        System.out.println("In test file");
    }
    @Test
    public void itemTest () {
        Item item = new Item();
        int itemId=1;
        String assetName= "laptop";
        String assetNo="Lap001";
        String assetType="Hardware";
        String dateOfPurchase = "12/07/2022";
        String warrantyPeriod ="2 years";
        String assetLocation ="Indore";
        boolean assignStatus =false;
        String workingStatus ="working";
        String incidents="Null";
        String employeeId ="N0001";
        
        item.setItemId(itemId);
        item.setAssetName(assetName);
        item.setAssetNo(assetNo);
        item.setAssetType(assetType);
        item.setdateOfPurchase(dateOfPurchase);
        item.setWarrantyPeriod(warrantyPeriod);
        item.setAssetLocation(assetLocation);
        item.setassignStatus(assignStatus);
        item.setWorkingStatus(workingStatus);
        item.setIncidents(incidents);
        item.setEmployeeId(employeeId);
        
        assertEquals(itemId, item.getItemId());
        assertEquals(assetName, item.getAssetName());
        assertEquals(assetNo, item.getAssetNo());
        assertEquals(assetType, item.getAssetType());
        assertEquals(dateOfPurchase, item.getdateOfPurchase());
        assertEquals(warrantyPeriod, item.getWarrantyPeriod());
        assertEquals(assetLocation, item.getAssetLocation());
        assertEquals(assignStatus, item.isassignStatus());
        assertEquals(workingStatus, item.getWorkingStatus());
        assertEquals(incidents, item.getIncidents());
        assertEquals(employeeId, item.getEmployeeId());
     
    }
    @Test
    public void testGettersAndSetters() {
        Item item= new Item();
        int itemId= 1;
        item.setItemId(itemId);
        assertEquals(itemId, item.getItemId());
        
        assertNull(item.getAssetName());
        String assetName = "Laptop";
        item.setAssetName(assetName);
        assertEquals(assetName, item.getAssetName());
        
        assertNull(item.getAssetNo());
        String assetNo ="Lap001";
        item.setAssetNo(assetNo);
        assertEquals(assetNo, item.getAssetNo());
        
        assertNull(item.getAssetType());
        String assetType = "Hardware";
        item.setAssetType(assetType);
        assertEquals(assetType, item.getAssetType());
        
        assertNull(item.getdateOfPurchase());
        String dateOfPurchase = "12/07/2022";
        item.setdateOfPurchase(dateOfPurchase);
        assertEquals(dateOfPurchase, item.getdateOfPurchase());
        
        assertNull(item.getWarrantyPeriod());
        String warrantyPeriod = "1 years";
        item.setWarrantyPeriod(warrantyPeriod);
        assertEquals(warrantyPeriod, item.getWarrantyPeriod());
        
        assertNull(item.getAssetLocation());
        String assetLocation = "Indore";
        item.setAssetLocation(assetLocation);
        assertEquals(assetLocation, item.getAssetLocation());
        
       // assertNull(item.isassignStatus());
        boolean assignStatus =false;
        item.setassignStatus(assignStatus);
        assertEquals(assignStatus, item.isassignStatus());
        
        assertNull(item.getWorkingStatus());
        String workingStatus = "working";
        item.setWorkingStatus(workingStatus);
        assertEquals(workingStatus, item.getWorkingStatus());
        
        assertNull(item.getIncidents());
        String incidents = "Null";
        item.setIncidents(incidents);
        assertEquals(incidents, item.getIncidents());
        
        assertNull(item.getEmployeeId());
        String employeeId = "N0001";
        item.setEmployeeId(employeeId);
        assertEquals(employeeId, item.getEmployeeId());
        
    }
    @Test
    public void testToString() {
 
        int itemId=1;
        String assetName= "laptop";
        String assetNo="Lap001";
        String assetType="Hardware";
        String dateOfPurchase = "12/07/2022";
        String warrantyPeriod ="2 years";
        String assetLocation ="Indore";
        boolean assignStatus =false;
        String workingStatus ="working";
        String incidents="Null";
        String employeeId ="N0001";
        
        Item itemDto = buildItemDto(itemId,assetName,assetNo,assetType,dateOfPurchase,warrantyPeriod,assetLocation,assignStatus,workingStatus ,incidents ,employeeId);
        assertNotNull(itemDto.toString());
        System.out.println(itemDto.toString());
//        assertEquals(,userDto.toString());
    }
    @Test
    public void testEqualsAndHashCode() {
        
        Item item = new Item();
    
        int itemId=1;
        String assetName= "laptop";
        String assetNo="Lap001";
        String assetType="Hardware";
        String dateOfPurchase = "12/07/2022";
        String warrantyPeriod ="2 years";
        String assetLocation ="Indore";
        boolean assignStatus =false;
        String workingStatus ="working";
        String incidents="Null";
        String employeeId ="N0001";
        

        Item itemDto1 = buildItemDto(itemId,assetName,assetNo,assetType,dateOfPurchase,warrantyPeriod,assetLocation,assignStatus,workingStatus ,incidents ,employeeId);
        Item itemDto2 = buildItemDto(itemId,assetName,assetNo,assetType,dateOfPurchase,warrantyPeriod,assetLocation,assignStatus,workingStatus ,incidents ,employeeId);
        
        assertEquals(itemDto1, itemDto2);
        assertEquals(itemDto1, itemDto2);
        assertEquals(false, itemDto1.equals(null));
        assertEquals(false,itemDto1.equals(item));
        System.out.println(itemDto1.toString().hashCode());
        System.out.println(itemDto1.toString().hashCode());
        assertEquals(itemDto1.hashCode(),itemDto2.hashCode());
    }
    public Item buildItemDto(int itemId,String assetName,String assetNo,String assetType,String dateOfPurchase,String warrantyPeriod,String assetLocation,boolean assignStatus,String workingStatus,String incidents, String employeeId) {
        Item itemDto = new Item();
        itemDto.setItemId(itemId);
        itemDto.setEmployeeId(employeeId);
        itemDto.setAssetName(assetName);
        itemDto.setAssetNo(assetNo);
        itemDto.setAssetType(assetType);
        itemDto.setdateOfPurchase(dateOfPurchase);
        itemDto.setWarrantyPeriod(warrantyPeriod);
        itemDto.setAssetLocation(assetLocation);
        itemDto.setassignStatus(assignStatus);
        itemDto.setWorkingStatus(workingStatus);
        itemDto.setIncidents(incidents);
        return itemDto;
     
    }

}
