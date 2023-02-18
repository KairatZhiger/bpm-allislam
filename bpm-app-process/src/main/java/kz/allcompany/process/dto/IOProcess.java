package kz.allcompany.process.dto;

import kz.allcompany.page.lib.enums.TaskStatus;
import kz.allcompany.process.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created By Kairat Zhiger
 * at 12.01.2023
 */
@Data
@Builder
public class IOProcess {
    private Long id;
    private String name;
    private UserEntity author;
    private LocalDateTime createDate;
    private UserEntity executor;
    private TaskStatus status;
}
