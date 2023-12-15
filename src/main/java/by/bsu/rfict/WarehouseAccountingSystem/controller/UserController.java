package by.bsu.rfict.WarehouseAccountingSystem.controller;

import by.bsu.rfict.WarehouseAccountingSystem.dto.UserDto;
import by.bsu.rfict.WarehouseAccountingSystem.mapper.UserMapper;
import by.bsu.rfict.WarehouseAccountingSystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/cabinet")
    public UserDto getUserInfo() {
        return userMapper.toUserDto(userService.getUserByLogin());
    }
}
