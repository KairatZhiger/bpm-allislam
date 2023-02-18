package kz.allcompany.process.repository;


import kz.allcompany.process.entity.ProcessEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@Repository
public interface ProcessRepository extends CrudRepository<ProcessEntity,Long> {
        List<ProcessEntity> findTaskEntitiesByCreateAuthorId(Long id);
        List<ProcessEntity> findTaskEntitiesByExecutorId(Long id);
}
