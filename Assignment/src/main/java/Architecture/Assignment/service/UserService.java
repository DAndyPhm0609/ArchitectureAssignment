package Architecture.Assignment.service;

import Architecture.Assignment.model.UserRole;
import Architecture.Assignment.model.User;
import Architecture.Assignment.repo.RolesRepo;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //function to get all the user in the list
    public List<User> getUser(){
        return userRepo.findAll();
    }

    //Function to add user into the repository
    public User addUser(String username, String password) {
        UserRole userRole = rolesRepo.findByAuthority("USER").get();
        Set<UserRole> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepo.save(new User(0, username, password, authorities));
    }


    public String deleteUserByID(Integer Id) {
        userRepo.deleteById(Id);
        return ("user deleted");
    }

    public User getUserByID(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

}
