package com.nt.project.inventorymanagement.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.project.inventorymanagement.domain.Item;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.EmployeeInDto;
import com.nt.project.inventorymanagement.dto.EmployeeOutDto;
import com.nt.project.inventorymanagement.dto.ItemInDto;
import com.nt.project.inventorymanagement.dto.ItemOutDto;
import com.nt.project.inventorymanagement.dto.UpdateEmployeeInDto;
import com.nt.project.inventorymanagement.dto.UpdateItemInDto;
import com.nt.project.inventorymanagement.service.AdminService;
/**
 * @author Sejal Jain.
 *
 */
@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
public class AdminController {
    /**
     * AdminService adminservice.
     */
    @Autowired
    private AdminService adminService;
    /**
     * @param itemInDto : ItemInDto Object.
     * @return itemDto.
     */
    @PostMapping("/item")
    public final ResponseEntity<ItemOutDto> addAsset(
            final @Valid @RequestBody ItemInDto itemInDto) {
        ItemOutDto itemDtoOut = adminService.addAsset(itemInDto);
        if (itemDtoOut.getMessage().equals("Item added Successfully")) {
            return ResponseEntity.status(HttpStatus.OK).body(itemDtoOut);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    /**
     * @param employeeInDto : EmployeeInDto.
     * @return employeeInDto.
     */
    @PostMapping("/employee")
    public final ResponseEntity<EmployeeOutDto> addEmployee(
            final @Valid @RequestBody EmployeeInDto employeeInDto) {
        EmployeeOutDto employeeOutDto = adminService.addEmployee(employeeInDto);
        if (employeeOutDto.getMessage().equals("Employee added successfully")) {
            return ResponseEntity.status(HttpStatus.OK).body(employeeOutDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    /**
     * @return List of Item.
     */
    @GetMapping("/items")
    public final List<Item> getItems() {
        return this.adminService.getItems();
    }
    /**
     * @return List Of Employees.
     */
    @GetMapping("/employees")
    public final List<User> getEmployees() {
        return this.adminService.getEmployees();
    }
    /**
     * @param updateItemInDto : updateItemInDto.
     * @return updateOutDto.
     */
    @PutMapping("/item")
    public final ResponseEntity<ItemOutDto> updateItem(
            @Valid @RequestBody final UpdateItemInDto updateItemInDto) {
        ItemOutDto updatedResult = adminService.updateItem(updateItemInDto);
        if (updatedResult.getMessage().equals("Item Updated successfully")) {
            return ResponseEntity.status(
                    HttpStatus.OK).body(updatedResult);
        } else {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(updatedResult);
        }
    }
    /**
     * @param updateEmployeeInDto : updateEmployeeInDto.
     * @return employeeOutDto.
     */
    @PutMapping("/employee")
    public final ResponseEntity<EmployeeOutDto> updateEmployee(
            @Valid @RequestBody final UpdateEmployeeInDto updateEmployeeInDto) {
        EmployeeOutDto updatedResult =
                adminService.updateEmployee(updateEmployeeInDto);
        if (updatedResult.getMessage().
                equals("Employee Updated successfully")) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedResult);
        } else {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(updatedResult);
        }
    }
}
