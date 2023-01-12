package kz.allcompany.task.dto;

import kz.allcompany.task.entity.UserEntity;
import kz.allcompany.page.lib.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created By Kairat Zhiger
 * at 12.01.2023
 */
@Data
@Builder
public class IOTask {
    private Long id;
    private String name;
    private UserEntity author;
    private LocalDateTime createDate;
    private UserEntity executor;
    private TaskStatus status;
}
