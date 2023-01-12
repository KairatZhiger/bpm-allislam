package kz.allcompany.page.lib.db;

import kz.allcompany.page.lib.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class TaskBaseModel extends DateBase{
    private String name;
    private String subject;
    private TaskStatus status;

}
