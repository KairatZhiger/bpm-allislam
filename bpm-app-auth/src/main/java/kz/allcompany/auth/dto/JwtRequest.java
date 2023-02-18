package kz.allcompany.auth.dto;

import lombok.Data;

/**
 * Created By Kairat Zhiger
 * at 17.02.2023
 */
@Data
public class JwtRequest {
    private String username;
    private String password;
    private String refreshToken;

}
