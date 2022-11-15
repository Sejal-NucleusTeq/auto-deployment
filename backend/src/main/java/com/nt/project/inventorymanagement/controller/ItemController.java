package com.nt.project.inventorymanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nt.project.inventorymanagement.dto.AssetAssignInDto;
import com.nt.project.inventorymanagement.service.ItemService;
/**
 * @author Sejal Jain.
 *
 */
@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
public class ItemController {
    /**
     * itemService.
     */
    @Autowired
    private ItemService itemService;
    /**
     * @param employeeId : employeeId.
     * @return employee.
     */
    @GetMapping("/employeeDetails")
    public final  Map<String, Object> getEmployeeDetails(final @RequestParam String employeeId) {
        return itemService.getAssignedAssets(employeeId);
    }
    /**
     * @param assetAssignInDto : assetAssignInDto.
     * @return assetAssign.
     */
    @PostMapping("/assignItem")
    public final ResponseEntity<Map<String, String>> assignAsset(
            final @Valid @RequestBody List<AssetAssignInDto> assetAssignInDto) {
        Map<String, String> map = new HashMap<>();
        if (this.itemService.setItems(assetAssignInDto)) {
            map.put("success", "Successful assignment of items");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.put("error", "Something goes wrong!!");
        }
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * @param id : id .
     * @return deleteAssignedItem.
     */
    @DeleteMapping("/deleteAssignedItem")
    public final ResponseEntity<Map<String, String>> deleteAssignedItem(final @RequestParam String id) {
        Map<String, String> map = new HashMap<>();
        this.itemService.deleteAssignedItem(Integer.valueOf(id));
        map.put("success", "Successful delete assignment of items");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * @return List.
     */
    @GetMapping("/getAllItems")
    public final ResponseEntity<?> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    /**
     * @return List.
     */
    @GetMapping("/getUnassignedItems")
    public final ResponseEntity<?> getAllUnassignedItems() {
        return new ResponseEntity<>(itemService.getAllUnassignedItems(), HttpStatus.OK);
    }
}
