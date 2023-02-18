package kz.allcompany.process.service;

import kz.allcompany.page.lib.enums.TaskStatus;
import kz.allcompany.process.dto.IOProcess;
import kz.allcompany.process.entity.ProcessEntity;
import kz.allcompany.process.repository.ProcessRepository;
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
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;

    @Override
    public Page<IOProcess> getProcessIncome(Locale locale, PageRequest page, Long clientId) {
        var tasks = processRepository.findTaskEntitiesByCreateAuthorId(clientId)
                .stream()
                .sorted(Comparator.comparing(ProcessEntity::getCreated).reversed())
                .map(taskEntity -> IOProcess.builder()
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
    public Page<IOProcess> getProcessOutCome(Locale locale, PageRequest page, Long clientId) {

        var tasks = processRepository.findTaskEntitiesByExecutorId(clientId)
                .stream()
                .sorted(Comparator.comparing(ProcessEntity::getCreated).reversed())
                .map(taskEntity -> IOProcess.builder()
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
    public ProcessEntity createProcess(ProcessEntity taskEntity, Long clientId) {
        return processRepository.save(taskEntity);
    }
}
