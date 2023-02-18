package kz.allcompany.process.controller;

import kz.allcompany.process.dto.IOProcess;
import kz.allcompany.process.entity.ProcessEntity;
import kz.allcompany.process.service.ProcessService;
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
public class ProcessController {

    private final ProcessService processService;


    @PostMapping("/create")
    public ProcessEntity getIncomes(
            Locale locale,
            @RequestHeader("user-iin") String iin,
            @RequestParam("clientId") Long clientId,
            @RequestBody ProcessEntity taskEntity

            ){

        return processService.createProcess(taskEntity,clientId);
    }

    @GetMapping("/income")
    public Page<IOProcess> getIncomes(
            Locale locale,
            @RequestHeader("user-iin") String iin,
            @RequestParam("clientId") Long clientId,
            @RequestParam("size") int size,
            @RequestParam("page") int page

            ){

        return processService.getProcessIncome(locale, PageRequest.of(page, size),clientId);
    }

    @GetMapping("/outcome")
    public Page<IOProcess> getOutcomes(
            Locale locale,
            @RequestHeader("user-iin") String iin,
            @RequestParam("clientId") Long clientId,
            @RequestParam("size") int size,
            @RequestParam("page") int page

    ){

        return processService.getProcessOutCome(locale, PageRequest.of(page, size),clientId);
    }
}
