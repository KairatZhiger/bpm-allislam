package kz.allcompany.page.dto;

import kz.allcompany.page.entity.PService;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@Data
@Builder
public class PServiceRs {
    private String logoPath;
    private String note;
    private List<PService> services;
}
