package kz.allcompany.page.service;

import kz.allcompany.page.dto.PServiceRs;
import kz.allcompany.page.lib.enums.Language;
import kz.allcompany.page.lib.util.LanguageUtils;
import kz.allcompany.page.repository.PServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PServiceRepository pServiceRepository;
    @Value("${app.main-logo-path}")
    private String mainLogo;

    @Override
    public PServiceRs getServices(Language language) {
        return PServiceRs.builder()
                .logoPath(mainLogo)
                .note("")
                .services(pServiceRepository.findAll().stream().peek(pService -> pService.setName(LanguageUtils.languageHandler(pService.getName(),language))).collect(Collectors.toList()))
                .build();

    }
}
