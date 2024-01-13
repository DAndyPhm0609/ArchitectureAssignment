package Architecture.Assignment.service;

import Architecture.Assignment.model.UserRole;
import Architecture.Assignment.model.User;
import Architecture.Assignment.repo.RolesRepo;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //function to get all of the user in the list
    public List<User> getUser(){
        return userRepo.findAll();
    }

    //Function to add user into the repository
    public User addUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        UserRole userRole = rolesRepo.findByAuthority("USER").get();
        Set<UserRole> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepo.save(new User(0, username, encodedPassword, authorities));
    }

    public String deleteUserByID(Integer Id) {
        userRepo.deleteById(Id);
        return ("user deleted");
    }

    public User getUserByID(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

}
