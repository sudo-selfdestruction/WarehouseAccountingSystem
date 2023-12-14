package by.bsu.rfict.WarehouseAccountingSystem.service;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Role;
import by.bsu.rfict.WarehouseAccountingSystem.entity.User;
import by.bsu.rfict.WarehouseAccountingSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String[] roleNames = user.getUserRolesList().stream().map(Role::getName).toArray(String[]::new);
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword())
                .roles(roleNames).build();
    }

}