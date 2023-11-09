package by.bsu.rfict.WarehouseAccountingSystem.repository;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String roleName);
}
