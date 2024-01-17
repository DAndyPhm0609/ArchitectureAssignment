package Architecture.Assignment.service;

import java.util.HashSet;
import java.util.Set;

import Architecture.Assignment.model.LoginObject;
import Architecture.Assignment.model.User;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Architecture.Assignment.model.UserRole;
import Architecture.Assignment.repo.RolesRepo;
@Service
@Transactional
public class AuthService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RolesRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public User registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        UserRole userRole = roleRepository.findByAuthority("USER").get();

        Set<UserRole> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new User(0, username, encodedPassword, authorities));
    }

    public LoginObject loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginObject(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginObject(null, "");
        }
    }

}