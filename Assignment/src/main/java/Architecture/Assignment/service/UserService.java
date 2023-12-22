package Architecture.Assignment.service;

import Architecture.Assignment.model.User;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

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

    public String deleteUserByID(Long Id) {
        userRepo.deleteById(Id);
        return ("book deleted");
    }

    public User getUserByID(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
