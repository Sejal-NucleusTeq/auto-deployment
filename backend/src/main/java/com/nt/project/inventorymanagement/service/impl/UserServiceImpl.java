package com.nt.project.inventorymanagement.service.impl;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.ResetPwdOutDto;
import com.nt.project.inventorymanagement.dto.UserInDto;
import com.nt.project.inventorymanagement.dto.UserLoginInDto;
import com.nt.project.inventorymanagement.dto.UserLoginOutDto;
import com.nt.project.inventorymanagement.dto.UserOutDto;
import com.nt.project.inventorymanagement.exception.ValidationException;
import com.nt.project.inventorymanagement.repository.UserRepository;
import com.nt.project.inventorymanagement.service.UserService;
/**
 * @author Sejal Jain.
 *
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * modelMapper: id for mapping.
     */
    private ModelMapper modelMapper = new ModelMapper();
    /**
     * userRepository :for data..
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * @param userInDto : user..
     * @return userOutDto .
     */
    @Override
    public final UserOutDto createUser(final UserInDto userInDto) {
        UserOutDto userOutDto = new UserOutDto();
        if (userRepository.findByEmail(userInDto.getEmail()).isPresent()) {
            throw new ValidationException("User Already Exist");
        }
        User user = new User();
        user = modelMapper.map(userInDto, User.class);
        userOutDto.setMessage("Registration Successfull");
        userRepository.save(user);
        return userOutDto;
    }
    /**
     * @param userLoginInDto : loginDto.
     * @return userLoginOutDto.
     */
    public final UserLoginOutDto login(final UserLoginInDto userLoginInDto) {
        UserLoginOutDto userLoginOutDto = new UserLoginOutDto();
        Optional<User> optionalEmailAndPassword =
                userRepository.findByEmailAndPassword(userLoginInDto.getEmail(),
                userLoginInDto.getPassword());
        System.out.println("---->" + optionalEmailAndPassword);
        if (!optionalEmailAndPassword.isPresent()) {
            throw new ValidationException("Login Failed");
        } else {
            User entity = optionalEmailAndPassword.get();
                userLoginOutDto.setFirstName(entity.getFirstName());
                userLoginOutDto.setRole(entity.getRole());
                userLoginOutDto.setEmployeeId(entity.getEmployeeId());
                userLoginOutDto.setFirstLogin(entity.isFirstLogin());
                System.out.println("---> userLoginOutDto" + userLoginOutDto);
        }
        return userLoginOutDto;
    }
//    @Override
//    public final boolean resetPassword(final UserLoginInDto userLoginInDto) {
//        User user = userRepository.findByEmail(userLoginInDto.getEmail()).get();
//        if (user != null) {
//            user.setPassword(userLoginInDto.getPassword());
//            userRepository.save(user);
//            return true;
//        }
//        return false;
//    }
    @Override
    public final ResetPwdOutDto resetPassword(final UserLoginInDto userInDto) {
        ResetPwdOutDto userDtoOut = new ResetPwdOutDto();
        System.out.println(userRepository.findByEmail(userInDto.getEmail()));
        User user = userRepository.findByEmail(userInDto.getEmail()).orElseThrow(() -> new ValidationException("User doesn't exist"));
        user.setPassword(userInDto.getPassword());
        user.setFirstLogin(false);
        userRepository.save(user);
        userDtoOut.setMessage("Password reset successfully");
        return userDtoOut;
    }
}
