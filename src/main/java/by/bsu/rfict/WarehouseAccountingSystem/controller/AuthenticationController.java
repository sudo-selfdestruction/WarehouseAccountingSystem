package by.bsu.rfict.WarehouseAccountingSystem.controller;

import by.bsu.rfict.WarehouseAccountingSystem.dto.LoginRequestDto;
import by.bsu.rfict.WarehouseAccountingSystem.dto.UserDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.User;
import by.bsu.rfict.WarehouseAccountingSystem.exception.UserNotFoundException;
import by.bsu.rfict.WarehouseAccountingSystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/user/login")
    public UserDto loginUser(@RequestBody LoginRequestDto loginDto) {
        String email = loginDto.getEmail();
        User user = userService.findByEmail(email);

        if (user != null && bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            log.info("login - user : {} successfully login", user);

            return UserDto.createUserDtoFromUser(user);
        } else {
            throw new UserNotFoundException("no user with such email/password");
        }
    }

    @PostMapping("user/sign-up")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        User user = UserDto.createUserFromUserDto(userDto);
        userService.registerUser(user);

        return userDto;
    }
}
