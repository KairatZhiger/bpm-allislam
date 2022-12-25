package kz.allcompany.auth.dto;

import lombok.Data;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}

