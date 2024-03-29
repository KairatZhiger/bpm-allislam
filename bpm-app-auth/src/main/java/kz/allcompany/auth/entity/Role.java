package kz.allcompany.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
@Entity
@Table(name = "role")
@Data
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private  List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + id + ", " +
                "name: " + name + "}";
    }
}