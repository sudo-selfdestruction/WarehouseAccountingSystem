package by.bsu.rfict.WarehouseAccountingSystem.repository;

import by.bsu.rfict.WarehouseAccountingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
