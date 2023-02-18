package kz.allcompany.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created By Kairat Zhiger
 * at 17.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse
{
    private  String user;
    private  String error;
    private  String accessToken;
    private  String refreshToken;
    private  int status;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }
    public JwtResponse(String user, String accessToken, String refreshToken, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.authorities = authorities;
    }

}
