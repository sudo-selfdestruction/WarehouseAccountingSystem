package by.bsu.rfict.WarehouseAccountingSystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Consumer {

    @Id
    private Long id;

}
