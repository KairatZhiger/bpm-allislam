package kz.allcompany.process.repository;


import kz.allcompany.process.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Kairat Zhiger
 * at 12.01.2023
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
