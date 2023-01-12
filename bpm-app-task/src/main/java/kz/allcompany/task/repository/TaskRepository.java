package kz.allcompany.task.repository;

import kz.allcompany.task.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
@Repository
public interface TaskRepository extends CrudRepository<TaskEntity,Long> {



   List<TaskEntity> findBy(Long aLong);

}
