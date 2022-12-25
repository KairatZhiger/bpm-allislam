package kz.allcompany.page.repository;

import kz.allcompany.page.entity.PService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@Repository
public interface PServiceRepository extends JpaRepository<PService,Long> {
}
