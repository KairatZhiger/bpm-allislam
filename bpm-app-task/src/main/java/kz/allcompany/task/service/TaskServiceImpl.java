package kz.allcompany.task.service;

import kz.allcompany.task.dto.IOTask;
import kz.allcompany.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Locale;

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
//        var tasks=taskRepository.findAllById(clientId)
//                .stream()
//                .sorted(Comparator.comparing(TaskEntity::getCreated)).map(taskEntity -> );
//
//        return new PageImpl<IOTask>(tasks,page, tasks.size());\
        return null;
    }

    @Override
    public Page<IOTask> getTaskOutCome(Locale locale, PageRequest page, Long clientId) {
        return null;
    }
}
