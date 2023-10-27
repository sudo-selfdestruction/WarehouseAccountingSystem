package by.bsu.rfict.WarehouseAccountingSystem.repository;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Consumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Long> {

}
