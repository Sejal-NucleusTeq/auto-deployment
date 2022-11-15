package com.nt.project.inventorymanagement.controller;
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

import com.nt.project.inventorymanagement.dto.ResetPwdOutDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserLoginInDto;
import com.nt.project.inventorymanagement.dto.UserLoginOutDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;
import com.nt.project.inventorymanagement.service.UserService;
/**
 * @author Sejal Jain.
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    /**
     * userService for userService.
     */
    @Autowired
    private UserService userService;
    /**
     * @return a string on home page
     */
    @GetMapping("/home")
    public final String home() {
        return "This is Inventory Management System";
    }
    /**
     * @param userInDto : userInDto.
     * @return user after registration
     */
    @PostMapping(path = "/register")
    public final ResponseEntity<UserOutDto> createUser(
            final @Valid @RequestBody UserInDto userInDto) {
        UserOutDto userOutDto = userService.createUser(userInDto);
        if (userOutDto.getMessage().equals("Registration Successfull")) {
            return ResponseEntity.status(HttpStatus.OK).body(userOutDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    /**
     * @param userLoginInDto : userLoginInDto.
     * @return user after login
     */
    @PostMapping("/login")
    public final ResponseEntity<UserLoginOutDto> login(
            final @Valid @RequestBody UserLoginInDto userLoginInDto) {
        UserLoginOutDto userLoginOutDto = userService.login(userLoginInDto);
        if (userLoginOutDto.getFirstName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(userLoginOutDto);
        }
    }
    /**
     * @param userInDto : userInDto.
     * @return ResetPwdOutDto.
     */
    @PutMapping("/reset")
    public final ResponseEntity<ResetPwdOutDto> resetPassword(@RequestBody
           final UserLoginInDto userInDto) {
        ResetPwdOutDto updatedResult = userService.resetPassword(userInDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedResult);
    }
}
