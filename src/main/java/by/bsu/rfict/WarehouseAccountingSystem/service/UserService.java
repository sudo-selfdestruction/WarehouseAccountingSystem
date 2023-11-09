package by.bsu.rfict.WarehouseAccountingSystem.service;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Role;
import by.bsu.rfict.WarehouseAccountingSystem.entity.User;
import by.bsu.rfict.WarehouseAccountingSystem.repository.RoleRepository;
import by.bsu.rfict.WarehouseAccountingSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(User user) {
        Role roleUser = roleRepository.findRoleByName("USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(roleUser);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRolesList(roleList);

        User registerdUser = userRepository.save(user);
        log.info("registerUser - user : {} successfully registered", registerdUser);

        return registerdUser;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
        log.info("deleteUser - user : {} successfully deleted", user);
    }

    public void deleteUser(Long userId) {
        if (userRepository.findById(userId) == null) {
            log.info("deleteUser - user with id {} didn't find", userId);
        }

        userRepository.deleteById(userId);
        log.info("deleteUser - user with id {} successfully deleted", userId);
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
