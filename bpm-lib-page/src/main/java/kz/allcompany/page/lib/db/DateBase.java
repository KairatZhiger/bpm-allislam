package kz.allcompany.page.lib.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class DateBase {
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;


}
