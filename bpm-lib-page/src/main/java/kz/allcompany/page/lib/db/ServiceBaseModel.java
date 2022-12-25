package kz.allcompany.page.lib.db;

import lombok.Data;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@Data
public class ServiceBaseModel {
    private String name;
    private String description;
    private String iconPath;
    private Integer priority;

}
