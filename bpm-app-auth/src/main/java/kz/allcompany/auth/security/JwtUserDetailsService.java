package kz.allcompany.auth.security;

import io.jsonwebtoken.Claims;
import kz.allcompany.auth.dto.JwtRequest;
import kz.allcompany.auth.dto.JwtResponse;
import kz.allcompany.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Kairat Zhiger
 * at 17.02.2023
 */
@AllArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {


    private JwtProvider jwtProvider;
    private UserRepository usersRepository;


    private final Map<String, String> refreshStorage = new HashMap<>();

    public JwtResponse login(@NonNull JwtRequest authRequest) {
        var user = usersRepository.findByUsername(authRequest.getUsername());
        if (user == null) {
            new AuthException("Пользователь не найден");
        }

        if (jwtProvider.passwordEncoder().matches(authRequest.getPassword(), user.getPassword())) {

            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getUserName(), refreshToken);
            return new JwtResponse(user.getUserName(), accessToken, refreshToken, getGrant(user.getRole()));
        } else {
            return new JwtResponse("Неправильный логин или пароль", 401);

        }
    }
    private List<GrantedAuthority> getGrant(int role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (role == 1 || role == 2) {
            authorities.add(new SimpleGrantedAuthority("GOD"));
        } else if (role == 3) {
            authorities.add(new SimpleGrantedAuthority("TEAM_PAYMENT"));
        } else if (role == 4) {
            authorities.add(new SimpleGrantedAuthority("PROVIDER"));
        } else if (role == 5) {
            authorities.add(new SimpleGrantedAuthority("CALL_CENTER"));
        } else {
            authorities.add(new SimpleGrantedAuthority("NOT_IMPLEMENTED"));
        }


        return authorities;
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) {

        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {


                var user = usersRepository.findByUsername(jwtProvider.getUsernameFromToken(refreshToken, 1));
                if (user != null) {
                    final String accessToken = jwtProvider.generateAccessToken(user);
                    return new JwtResponse(user.getUserName(), accessToken, refreshToken, getGrant(user.getRole()));
                } else {

                    return new JwtResponse("Пользователь не найден", 401);
                }


            } else {

                return new JwtResponse("Refresh token  null", 401);
            }
        } else {

            return new JwtResponse("Refresh token  no valid", 401);

        }

    }

    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final kz.allcompany.auth.entity.User user = usersRepository.findByUsername(jwtProvider.getUsernameFromToken(refreshToken, 1));
                if (user != null) {
                    final String accessToken = jwtProvider.generateAccessToken(user);
                    final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                    refreshStorage.put(user.getUserName(), newRefreshToken);
                    return new JwtResponse(user.getUserName(), accessToken, refreshToken, getGrant(user.getRole()));
                } else {

                    return new JwtResponse("Пользователь не найден", 401);
                }

            }
        }
        throw new AuthException("Невалидный JWT токен");
    }


    public UserDetails findByLoginAndToken(String token) {
        return loadUserByUsername(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        var user = usersRepository.findByUsername(username);
        return new User(user.getUserName(),
                user.getPassword(),
                user.isEnable(),
                user.isExpired(),
                false,
                user.isLocked(),
                getGrant(user.getRole()));

    }
}