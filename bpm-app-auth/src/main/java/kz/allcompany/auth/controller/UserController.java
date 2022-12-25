package kz.allcompany.auth.controller;

import kz.allcompany.auth.dto.UserDto;
import kz.allcompany.auth.entity.User;
import kz.allcompany.auth.enums.Status;
import kz.allcompany.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid User user) {
        return userService.register(user);
    }

    @GetMapping
    public User init() {
        var user = new User();
        user.setStatus(Status.ACTIVE);
        user.setUsername("u12633");
        user.setEmail("sherizatk@gmail.com");
        user.setFirstName("Zhiger");
        user.setLastName("Kairat");
        user.setPassword("admin");
        return user;
    }

}
