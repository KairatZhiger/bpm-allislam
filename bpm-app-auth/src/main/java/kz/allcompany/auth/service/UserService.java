package kz.allcompany.auth.service;

import kz.allcompany.auth.entity.User;

import java.util.List;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
