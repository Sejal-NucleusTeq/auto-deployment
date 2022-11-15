
package com.nt.project.inventorymanagement.service.impl;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.project.inventorymanagement.domain.Item;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.EmployeeInDto;
import com.nt.project.inventorymanagement.dto.EmployeeOutDto;
import com.nt.project.inventorymanagement.dto.GetEmployeeOutDto;
import com.nt.project.inventorymanagement.dto.ItemInDto;
import com.nt.project.inventorymanagement.dto.ItemOutDto;
import com.nt.project.inventorymanagement.dto.UpdateEmployeeInDto;
import com.nt.project.inventorymanagement.dto.UpdateItemInDto;
import com.nt.project.inventorymanagement.exception.ValidationException;
import com.nt.project.inventorymanagement.repository.ItemRepository;
import com.nt.project.inventorymanagement.repository.UserRepository;
import com.nt.project.inventorymanagement.service.AdminService;
/**
 * @author Sejal Jain.
 */
@Service
public class AdminServiceImpl implements AdminService {
    /**
     * ModelMapper modelMapper.
     */
    private ModelMapper modelMapper = new ModelMapper();
    /**
     * ItemRepository itemRepository.
     */
    @Autowired
    private ItemRepository itemRepository;
    /**
     * UserRepository userRepository.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * @return ItemOutDto.
     */
    @Override
    public final ItemOutDto addAsset(final ItemInDto itemInDto) {
        // TODO Auto-generated method stub
        ItemOutDto itemOutDto = new ItemOutDto();
        if (itemRepository.findByAssetNo(itemInDto.getAssetNo()).isPresent()) {
            throw new ValidationException("Item Already Exist");
            // System.out.print("-----> Item Alreay Exist"+itemInDto);
        }
        Item item = new Item();
        item = modelMapper.map(itemInDto, Item.class);
        item.setWorkingStatus("working");
        item.setassignStatus(false);
        item.setIncidents(null);
        item.setdateOfPurchase(itemInDto.getDop());
        itemOutDto.setMessage("Item added Successfully");
        itemRepository.save(item);
        return itemOutDto;
    }
    /**
     * @return EmployeeDto.
     */
    @Override
    public final EmployeeOutDto addEmployee(
            final @Valid EmployeeInDto employeeInDto) {
        EmployeeOutDto employeeOutDto = new EmployeeOutDto();
        if (userRepository.findByEmail(employeeInDto.getEmail()).isPresent()) {
            throw new ValidationException("Email Already Exist");
        } else if (userRepository.findByEmployeeId(
                employeeInDto.getEmployeeId()).isPresent()) {
            throw new ValidationException("EmployeeId Already Exist");
        } else if (userRepository.findByPhoneNo(
                employeeInDto.getPhoneNo()).isPresent()) {
            throw new ValidationException("PhoneNo Already Exist");
        }
        User user = modelMapper.map(employeeInDto, User.class);
        employeeOutDto.setMessage("Employee added successfully");
        System.out.println(user.toString());
        String[] format = employeeInDto.getDateOfBirth().split("-");
        String password = employeeInDto.getEmployeeId() + "@";
        for (String st : format) {
            password += st;
        }
        user.setPassword(password);
        userRepository.save(user);
        return employeeOutDto;
    }
    /**
     * @return List<Item>.
     */
    @Override
    public final List<Item> getItems() {
        // TODO Auto-generated method stub
        return itemRepository.findAll();
    }
    /**
     * @return List<User>.
     */
    @Override
    public final List<User> getEmployees() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }
    @Override
    public final ItemOutDto updateItem(final
            @Valid UpdateItemInDto updateItemInDtoIn) {
        ItemOutDto itemOutDto = new ItemOutDto();
        Item item = itemRepository.findByAssetNo(updateItemInDtoIn.getAssetNo())
                .orElseThrow(() -> new ValidationException("Item Not found"));
        item = modelMapper.map(updateItemInDtoIn, Item.class);
        itemRepository.save(item);
        itemOutDto.setMessage("Item Updated successfully");
        return itemOutDto;
    }
    @Override
    public final EmployeeOutDto updateEmployee(final
            @Valid UpdateEmployeeInDto updateEmployeeInDto) {
        // TODO Auto-generated method stub
        EmployeeOutDto employeeOutDto = new EmployeeOutDto();
        User user = userRepository.findById(updateEmployeeInDto.getUserId())
             .orElseThrow(() -> new ValidationException("Employee Not found"));
        user = modelMapper.map(updateEmployeeInDto, User.class);
        userRepository.save(user);
        employeeOutDto.setMessage("Employee Updated successfully");
        return employeeOutDto;
    }
    @Override
    public  final GetEmployeeOutDto getEmployeeDetails(final String employeeId) {
        Optional<User> emp  = userRepository.findByEmployeeId(employeeId);
        GetEmployeeOutDto employeeDetails = new GetEmployeeOutDto();
        if (!emp.isPresent()) {
            throw new ValidationException("Employee Does Not Exist");
        }
        User user = emp.get();
        employeeDetails = modelMapper.map(user, GetEmployeeOutDto.class);
        return employeeDetails;
    }
}
