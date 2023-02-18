package kz.allcompany.process.service;


import kz.allcompany.process.dto.IOProcess;
import kz.allcompany.process.entity.ProcessEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Locale;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
public interface ProcessService
{
    Page<IOProcess> getProcessIncome(Locale locale, PageRequest page, Long clientId);
    Page<IOProcess> getProcessOutCome(Locale locale, PageRequest page, Long clientId);

    ProcessEntity createProcess(ProcessEntity taskEntity, Long clientId);

}
