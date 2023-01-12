package kz.allcompany.page.repository;

import kz.allcompany.page.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Kairat Zhiger
 * at 29.12.2022
 */
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
