package Architecture.Assignment.service;

import Architecture.Assignment.model.LoginResponseDTO;
import Architecture.Assignment.model.User;
import Architecture.Assignment.model.UserRole;
import Architecture.Assignment.repo.RolesRepo;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User addUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        UserRole userRole = rolesRepo.findByAuthority("USER").get();
        Set<UserRole> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepo.save(new User(0, username, encodedPassword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            return new LoginResponseDTO(userRepo.findByUsername(username).get(), true);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, false);
        }
    }
}
