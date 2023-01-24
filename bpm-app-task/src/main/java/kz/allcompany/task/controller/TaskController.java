package kz.allcompany.task.controller;

import kz.allcompany.task.dto.IOTask;
import kz.allcompany.task.entity.TaskEntity;
import kz.allcompany.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@RestController
@RequestMapping(value = "/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping("/create")
    public TaskEntity getIncomes(
            Locale locale,
            @RequestHeader("user-iin") String iin,
            @RequestParam("clientId") Long clientId,
            @RequestBody TaskEntity taskEntity

            ){

        return taskService.createTask(taskEntity,clientId);
    }

    @GetMapping("/income")
    public Page<IOTask> getIncomes(
            Locale locale,
            @RequestHeader("user-iin") String iin,
            @RequestParam("clientId") Long clientId,
            @RequestParam("size") int size,
            @RequestParam("page") int page

            ){

        return taskService.getTaskIncome(locale, PageRequest.of(page, size),clientId);
    }

    @GetMapping("/outcome")
    public Page<IOTask> getOutcomes(
            Locale locale,
            @RequestHeader("user-iin") String iin,
            @RequestParam("clientId") Long clientId,
            @RequestParam("size") int size,
            @RequestParam("page") int page

    ){

        return taskService.getTaskOutCome(locale, PageRequest.of(page, size),clientId);
    }
}
