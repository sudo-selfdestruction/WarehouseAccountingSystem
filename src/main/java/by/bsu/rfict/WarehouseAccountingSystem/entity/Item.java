package by.bsu.rfict.WarehouseAccountingSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "manufacturing_country")
    private String manufacturingCountry;

    @Column(name = "cost")
    private int cost;

    @Column(name = "weight")
    private double weight;

    @JsonIgnore
    @ManyToMany(mappedBy = "itemList", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
