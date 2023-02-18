package kz.allcompany.auth.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;
import kz.allcompany.auth.dto.JwtRequest;
import kz.allcompany.auth.dto.JwtResponse;
import kz.allcompany.auth.security.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;

/**
 * Created By Kairat Zhiger
 * at 13.12.2022
 */

//@Tag(name = "Авторизация", description = "Авторизация c использованием JWT токена")
@RestController
@RequestMapping(value = "/v1/auth/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService userDetailsService;


//    @Operation(summary = "Создание авторизационного токена",
//            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

        final JwtResponse token = userDetailsService.login(authenticationRequest);

        if (token.getError()!=null){
            return  new ResponseEntity<>(
                    token, HttpStatus.FORBIDDEN);
        }

        return  new ResponseEntity<>(
                token, HttpStatus.OK);
    }




//    @Operation(summary = "Получение нового access-token",
//            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody JwtRequest request) {
        final JwtResponse token = userDetailsService.getAccessToken(request.getRefreshToken());
        if (token.getError()!=null){
            return  new ResponseEntity<>(
                    token, HttpStatus.FORBIDDEN);
        }

        return  new ResponseEntity<>(
                token, HttpStatus.OK);
    }


//    @Operation(summary = "Получение нового access-token",
//            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "refresh")
    public ResponseEntity<?> getNewRefreshToken(@RequestBody JwtRequest request) throws AuthException {

        final JwtResponse token = userDetailsService.refresh(request.getRefreshToken());
        if (token.getError()!=null){
            return  new ResponseEntity<>(
                    token, HttpStatus.FORBIDDEN);
        }

        return  new ResponseEntity<>(
                token, HttpStatus.OK);
    }
}
