package com.nt.project.inventorymanagement.service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.project.inventorymanagement.dto.ResetPwdOutDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserLoginInDto;
import com.nt.project.inventorymanagement.dto.UserLoginOutDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;

/**
 * @author Sejal Jain.
 *
 */
public interface UserService {
    /**
     * @param userInDto : user details.
     * @return : createUser.
     */
    @ResponseBody
    UserOutDto createUser(@RequestBody UserInDto userInDto);
    /**
     * @param userLoginInDto : user login detsils.
     * @return : login.
     */
    @ResponseBody
    UserLoginOutDto login(@RequestBody UserLoginInDto userLoginInDto);
    /**
     * @param userInDto : userInDto.
     * @return boolean.
     */
    ResetPwdOutDto resetPassword(UserLoginInDto userInDto);
}
