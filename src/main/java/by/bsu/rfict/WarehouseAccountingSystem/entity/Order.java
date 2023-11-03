package by.bsu.rfict.WarehouseAccountingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "measurement_unit")
    private String measurementUnit;

    @Column(name = "total_weight")
    private short weight;

    @Column(name = "package")
    private boolean pack;

    @Column(name = "total_cost")
    private int cost;

    @Column(name = "storage_period")
    private Date storage_period;

    @Column(name = "order_date")
    private Date order_date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> itemList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
