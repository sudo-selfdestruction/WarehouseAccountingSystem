package by.bsu.rfict.WarehouseAccountingSystem.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "userRolesList", fetch = FetchType.LAZY)
    private List<User> userList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' + '}';
    }
}
