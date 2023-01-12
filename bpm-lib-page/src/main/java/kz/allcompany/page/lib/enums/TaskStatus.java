package kz.allcompany.page.lib.enums;

import lombok.AllArgsConstructor;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */

@AllArgsConstructor
public enum TaskStatus {
    NEW("Новая задача"),IN_PROGRESS ("В работе"),OVER_DATE_TIME("Просрочен"),CLOSED("Закрыт"),DONE("Исполнен"),CANCELLED("Отменен");

    private String description;


}
