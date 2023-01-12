package kz.allcompany.task.controller;

import kz.allcompany.task.dto.IOTask;
import kz.allcompany.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@RestController("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

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
}
