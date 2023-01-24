package kz.allcompany.task.entity;

import kz.allcompany.page.lib.enums.TaskStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@Entity
@Table(name = "task")
@Data
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**Создатель задачи*/
    @OneToOne
    private UserEntity createAuthor;
    /***/
    @OneToOne
    private UserEntity modifyUser;

    /**Исполнитель*/
    @OneToOne
    private UserEntity executor;

    private LocalDateTime startWorkDate;

    /**Название задачи*/
    private String name;

    private String subject;
    private TaskStatus status;

    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;
//    @ManyToMany(mappedBy = "id",fetch = FetchType.EAGER)
//
//    private Set<UserEntity> coExecutor;


}
