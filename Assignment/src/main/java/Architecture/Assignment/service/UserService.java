package Architecture.Assignment.service;

import Architecture.Assignment.model.User;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //function to get all of the book in the list
    public List<User> getUser(){
        return userRepo.findAll();
    }

    //Function to add book into the repository
    public User addUser(User user) {
        return userRepo.save(user);
    }

    public String deleteUserByID(Integer Id) {
        userRepo.deleteById(Id);
        return ("user deleted");
    }

    public User getUserByID(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

}
