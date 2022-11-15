package com.nt.project.inventorymanagement.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nt.project.inventorymanagement.domain.AssetAssign;


public class AssetAssignInDtoTest {
    @Test
    public void AssetAssignInDtoTest() {
        AssetAssignInDto assign = new AssetAssignInDto();
        int id = 6;
        String itemtableId = "4";
        int employeeTableId = 4;
        String employeeId = "N0033";
        String itemReceivedAt = "Home";
        String assignedDate = "28/09/2000";
        String createdAt = "993388";
        String updatedAt = "22/430/33";
        
        assign.setId(id);
        assign.setAssetTableId(itemtableId);
        assign.setEmployeeTableId(employeeTableId);
        assign.setEmployeeId(employeeId);
        assign.setAssetReceivedBy(itemReceivedAt);
        assign.setDateOfAssigned(assignedDate);
        
        assertEquals(id,assign.getId());
        assertEquals(itemtableId,assign.getAssetTableId());
        assertEquals(employeeTableId,assign.getEmployeeTableId());
        assertEquals(employeeId, assign.getEmployeeId());
        assertEquals(itemReceivedAt,assign.getAssetReceivedBy());
        assertEquals(assignedDate, assign.getDateOfAssigned());
            
    }
    
    
    @Test
    public void testGettersAndSetters() {
        
        AssetAssignInDto asset = new AssetAssignInDto();
        int id = 6;
        asset.setId(id);
        assertEquals(id, asset.getId());
        
        int employeeTableId = 1;
        asset.setEmployeeTableId(employeeTableId);
        assertEquals(employeeTableId, asset.getEmployeeTableId());
        
        String employeeId ="N0001";
        asset.setEmployeeId(employeeId);
        assertEquals(employeeId,asset.getEmployeeId());
        
        String assetTableId = "1";
        asset.setAssetTableId(assetTableId);
        assertEquals(assetTableId, asset.getAssetTableId());
        
        String assetNo = "Lap001";
        asset.setAssetNo(assetNo);
        assertEquals(assetNo, asset.getAssetNo());
        
        String assetName ="Laptop";
        asset.setAssetName(assetName);
        assertEquals(assetName, asset.getAssetName());
        
        String dateOfAssigned = "12/07/2022";
        asset.setDateOfAssigned(dateOfAssigned);
        assertEquals(dateOfAssigned, asset.getDateOfAssigned());
       
        String assetReceivedBy ="office";
        asset.setAssetReceivedBy(assetReceivedBy);
        assertEquals(assetReceivedBy, asset.getAssetReceivedBy());
        
    }
    @Test
    public void testToString() {
 
        int id=2;
        int employeeTableId =1;
        String employeeId =  "N0001";
        String assetTableId = "1";
        String assetNo = "Lap001";
        String assetName ="Laptop";
        String dateOfAssigned = "12/07/2022";
        String assetReceivedBy ="office";
        
        AssetAssignInDto assetDto = buildAssetAssignDto(id, employeeTableId,employeeId,assetTableId,assetNo,assetName,dateOfAssigned,assetReceivedBy);
        assertNotNull(assetDto.toString());
        System.out.println(assetDto.toString());
//        assertEquals(,userDto.toString());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        
        AssetAssignInDto asset = new AssetAssignInDto();
    
        int id=2;
        int employeeTableId =1;
        String employeeId =  "N0001";
        String assetTableId = "1";
        String assetNo = "Lap001";
        String assetName ="Laptop";
        String dateOfAssigned = "12/07/2022";
        String assetReceivedBy ="office";
        

        AssetAssignInDto assetDto1 = buildAssetAssignDto(id, employeeTableId,employeeId,assetTableId,assetNo,assetName,dateOfAssigned,assetReceivedBy);
        AssetAssignInDto assetDto2 = buildAssetAssignDto(id, employeeTableId,employeeId,assetTableId,assetNo,assetName,dateOfAssigned,assetReceivedBy);
        assertEquals(assetDto1, assetDto2);
        assertEquals(false, assetDto1.equals(null));
        assertEquals(false,assetDto1.equals(asset));
        System.out.println(assetDto1.toString().hashCode());
        System.out.println(assetDto2.toString().hashCode());
        assertEquals(assetDto1.hashCode(),assetDto2.hashCode());
    }
   
    public AssetAssignInDto buildAssetAssignDto(int id,int employeeTableId,String employeeId,String assetTableId,String assetNo,String assetName,String dateOfAssigned,String assetReceivedBy) {
        AssetAssignInDto assetDto = new AssetAssignInDto();
        assetDto.setId(id);
        assetDto.setEmployeeTableId(employeeTableId);
        assetDto.setEmployeeId(employeeId);
        assetDto.setAssetTableId(assetTableId);
        assetDto.setAssetNo(assetNo);
        assetDto.setAssetName(assetName);
        assetDto.setDateOfAssigned(dateOfAssigned);
        assetDto.setAssetReceivedBy(assetReceivedBy);
        
        return assetDto;
     
    }
}
