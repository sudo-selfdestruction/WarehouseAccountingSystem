package by.bsu.rfict.WarehouseAccountingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "measurement_unit")
    private String measurementUnit;

    @Column(name = "weight")
    private short weight;

    @Column(name = "package")
    private boolean pack;

    @Column(name = "cost")
    private int cost;

    @Column(name = "storage_period")
    private Date storage_period;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "manufacturing_country")
    private String manufacturingCountry;
}
