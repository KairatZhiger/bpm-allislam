package kz.allcompany.page.service;

import kz.allcompany.page.dto.PServiceRs;
import kz.allcompany.page.lib.enums.Language;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
public interface PageService {
    PServiceRs getServices(Language language);
}
