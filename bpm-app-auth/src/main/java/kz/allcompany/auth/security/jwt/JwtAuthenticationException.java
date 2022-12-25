package kz.allcompany.auth.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
