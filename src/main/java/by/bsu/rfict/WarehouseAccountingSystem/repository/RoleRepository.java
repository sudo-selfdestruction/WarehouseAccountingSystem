package by.bsu.rfict.WarehouseAccountingSystem.repository;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
