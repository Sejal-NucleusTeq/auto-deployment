package com.nt.project.inventorymanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AssetAssignTest {
    @Test
    public void assetAssignTest() {
        AssetAssign asset = new AssetAssign();
         int id=2;
         int employeeTableId =1;
         String employeeId =  "N0001";
         String assetTableId = "1";
         String assetNo = "Lap001";
         String assetName ="Laptop";
         String dateOfAssigned = "12/07/2022";
         String assetReceivedBy ="office";
         
         
         asset.setId(id);
         asset.setEmployeeTableId(employeeTableId);
         asset.setEmployeeId(employeeId);
         asset.setAssetTableId(assetTableId);
         asset.setAssetNo(assetNo);
         asset.setAssetName(assetName);
         asset.setDateOfAssigned(dateOfAssigned);
         asset.setAssetReceivedBy(assetReceivedBy);
         
         assertEquals(id, asset.getId());
         assertEquals(employeeTableId, asset.getEmployeeTableId());
         assertEquals(employeeId,asset.getEmployeeId());
         assertEquals(assetTableId, asset.getAssetTableId());
         assertEquals(assetNo, asset.getAssetNo());
         assertEquals(assetName, asset.getAssetName());
         assertEquals(dateOfAssigned, asset.getDateOfAssigned());
         assertEquals(assetReceivedBy, asset.getAssetReceivedBy());
         
    }
    
    @Test
    public void testGettersAndSetters() {
        AssetAssign asset = new AssetAssign();
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
        
        AssetAssign assetDto = buildAssetAssignDto(id, employeeTableId,employeeId,assetTableId,assetNo,assetName,dateOfAssigned,assetReceivedBy);
        assertNotNull(assetDto.toString());
        System.out.println(assetDto.toString());
//        assertEquals(,userDto.toString());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        
        AssetAssign asset = new AssetAssign();
    
        int id=2;
        int employeeTableId =1;
        String employeeId =  "N0001";
        String assetTableId = "1";
        String assetNo = "Lap001";
        String assetName ="Laptop";
        String dateOfAssigned = "12/07/2022";
        String assetReceivedBy ="office";
        

        AssetAssign assetDto1 = buildAssetAssignDto(id, employeeTableId,employeeId,assetTableId,assetNo,assetName,dateOfAssigned,assetReceivedBy);
        AssetAssign assetDto2 = buildAssetAssignDto(id, employeeTableId,employeeId,assetTableId,assetNo,assetName,dateOfAssigned,assetReceivedBy);
        assertEquals(assetDto1, assetDto2);
        assertEquals(false, assetDto1.equals(null));
        assertEquals(false,assetDto1.equals(asset));
        System.out.println(assetDto1.toString().hashCode());
        System.out.println(assetDto2.toString().hashCode());
        assertEquals(assetDto1.hashCode(),assetDto2.hashCode());
    }
   
    public AssetAssign buildAssetAssignDto(int id,int employeeTableId,String employeeId,String assetTableId,String assetNo,String assetName,String dateOfAssigned,String assetReceivedBy) {
        AssetAssign assetDto = new AssetAssign();
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
