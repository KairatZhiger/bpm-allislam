package kz.allcompany.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

//    public User toUser(){
//        User user = new User();
//        user.setId(id);
//        user.getUserName(userName);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//
//        return user;
//    }

//    public static UserDto fromUser(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setUsername(user.getUserName());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//
//        return userDto;
//    }
}
