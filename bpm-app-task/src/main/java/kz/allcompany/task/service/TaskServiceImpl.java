package kz.allcompany.task.service;

import kz.allcompany.page.lib.enums.TaskStatus;
import kz.allcompany.task.dto.IOTask;
import kz.allcompany.task.entity.TaskEntity;
import kz.allcompany.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created By Kairat Zhiger
 * at 12.01.2023
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Page<IOTask> getTaskIncome(Locale locale, PageRequest page, Long clientId) {
        var tasks = taskRepository.findTaskEntitiesByCreateAuthorId(clientId)
                .stream()
                .sorted(Comparator.comparing(TaskEntity::getCreated).reversed())
                .map(taskEntity -> IOTask.builder()
                        .id(taskEntity.getId())
                        .status(TaskStatus.IN_PROGRESS)
                        .author(taskEntity.getCreateAuthor())
                        .name(taskEntity.getName())
                        .executor(taskEntity.getExecutor())
                        .createDate(taskEntity.getCreated())
                        .build()
                ).collect(Collectors.toList());

        return new PageImpl<>(tasks, page, tasks.size());
    }

    @Override
    public Page<IOTask> getTaskOutCome(Locale locale, PageRequest page, Long clientId) {

        var tasks = taskRepository.findTaskEntitiesByExecutorId(clientId)
                .stream()
                .sorted(Comparator.comparing(TaskEntity::getCreated).reversed())
                .map(taskEntity -> IOTask.builder()
                        .id(taskEntity.getId())
                        .status(TaskStatus.IN_PROGRESS)
                        .author(taskEntity.getCreateAuthor())
                        .name(taskEntity.getName())
                        .executor(taskEntity.getExecutor())
                        .createDate(taskEntity.getCreated())
                        .build()
                ).collect(Collectors.toList());
        return new PageImpl<>(tasks, page, tasks.size());

    }

    @Override
    public TaskEntity createTask(TaskEntity taskEntity, Long clientId) {
        return taskRepository.save(taskEntity);
    }
}
