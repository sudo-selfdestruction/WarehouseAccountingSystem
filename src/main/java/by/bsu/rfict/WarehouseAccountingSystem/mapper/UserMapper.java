package by.bsu.rfict.WarehouseAccountingSystem.mapper;

import by.bsu.rfict.WarehouseAccountingSystem.dto.UserDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
