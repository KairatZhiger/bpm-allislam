package kz.allcompany.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.allcompany.auth.enums.Status;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "user-entity-graph",
                includeAllAttributes = true

        )
})
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "password")
    @JsonIgnore
    private String password;


    @Column(name = "role_id")
    private Integer role;



    @Column(name = "enable")
    private boolean enable;

    @Column(name = "locked")
    private boolean locked;
    @Column(name = "expired")
    private boolean expired;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Role roles;

}