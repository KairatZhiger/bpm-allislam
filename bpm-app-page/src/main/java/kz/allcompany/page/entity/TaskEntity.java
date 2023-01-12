package kz.allcompany.page.entity;

import kz.allcompany.page.lib.db.TaskBaseModel;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@Entity
@Table(name = "task")
@Data
public class TaskEntity extends TaskBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**Создатель задачи*/
   // @OneToMany
    private String createAuthor;
    /***/
   // @OneToMany
    private String modifyUser;
    /**Исполнитель*/
  //  @OneToMany
    private String executor;

    private LocalDateTime startWorkDate;
//    @ManyToMany(mappedBy = "id",fetch = FetchType.EAGER)
//    private Set<User> coExecutor;


}
