package kz.allcompany.page.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}