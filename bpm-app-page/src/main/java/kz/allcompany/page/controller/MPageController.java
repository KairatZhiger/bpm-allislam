package kz.allcompany.page.controller;

import kz.allcompany.page.dto.PServiceRs;
import kz.allcompany.page.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@RestController("/v1/{lang}")
@RequiredArgsConstructor
public class MPageController {

    private PageService pageService;
    @GetMapping("/services")
    public PServiceRs getServices(){
        return
    }
}
