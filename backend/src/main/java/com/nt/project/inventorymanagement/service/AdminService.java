package com.nt.project.inventorymanagement.service;
import java.util.List;
import javax.validation.Valid;
import com.nt.project.inventorymanagement.domain.Item;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.EmployeeInDto;
import com.nt.project.inventorymanagement.dto.EmployeeOutDto;
import com.nt.project.inventorymanagement.dto.GetEmployeeOutDto;
import com.nt.project.inventorymanagement.dto.ItemInDto;
import com.nt.project.inventorymanagement.dto.ItemOutDto;
import com.nt.project.inventorymanagement.dto.UpdateEmployeeInDto;
import com.nt.project.inventorymanagement.dto.UpdateItemInDto;
/**
 * @author Sejal Jain.
 *
 */
public interface AdminService {
    /**
     * @param itemInDto : dto.
     * @return itemOutDto.
     */
    ItemOutDto addAsset(ItemInDto itemInDto);
    /**
     * @param employeeInDto : dto.
     * @return employeeOutDto.
     */
    EmployeeOutDto addEmployee(EmployeeInDto employeeInDto);
    /**
     * @return List<Item>.
     */
    List<Item> getItems();
    /**
     * @return List<Employee>
     */
    List<User> getEmployees();
    /**
     * @param updateItemInDtoIn : for updateInDto.
     * @return ItemOutDto.
     */
    ItemOutDto updateItem(@Valid UpdateItemInDto updateItemInDtoIn);
    /**
     * @param updateEmployeeInDto : for updateInDto.
     * @return return employeeOutDto.
     */
    EmployeeOutDto updateEmployee(
            @Valid UpdateEmployeeInDto updateEmployeeInDto);
    /**
     * @param employeeId : employeeId.
     * @return employeeId.
     */
    GetEmployeeOutDto getEmployeeDetails(String employeeId);
}
