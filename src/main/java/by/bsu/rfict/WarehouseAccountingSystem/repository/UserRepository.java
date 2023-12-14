package by.bsu.rfict.WarehouseAccountingSystem.repository;

import by.bsu.rfict.WarehouseAccountingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = :login")
    User getUserByLogin(String login);
}
