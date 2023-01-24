package kz.allcompany.task.service;

import kz.allcompany.task.dto.IOTask;
import kz.allcompany.task.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Locale;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
public interface TaskService
{
    Page<IOTask> getTaskIncome(Locale locale, PageRequest page, Long clientId);
    Page<IOTask> getTaskOutCome(Locale locale, PageRequest page, Long clientId);

    TaskEntity createTask(TaskEntity taskEntity, Long clientId);
}
