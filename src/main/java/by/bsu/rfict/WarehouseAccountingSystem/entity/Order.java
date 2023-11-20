package by.bsu.rfict.WarehouseAccountingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "total_weight")
    private double weight;

    @Column(name = "total_cost")
    private double cost;

    @Column(name = "storage_period")
    private LocalDate storage_period;

    @Column(name = "order_date")
    private LocalDate order_date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> itemList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
