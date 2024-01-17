package Architecture.Assignment.controller;

import Architecture.Assignment.model.LoginResponseDTO;
import Architecture.Assignment.model.RegisterObject;
import Architecture.Assignment.model.User;

import Architecture.Assignment.model.UserRole;
import Architecture.Assignment.repo.RolesRepo;
import Architecture.Assignment.service.AuthService;
import Architecture.Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    AuthService authService;

    @GetMapping("/auth/users")
    public List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/auth/roles")
    public List<UserRole> getRoles(){ return rolesRepo.findAll();}

    @PostMapping("/auth/add_user")
    public User addUser(@RequestBody RegisterObject registerObject) {
        return authService.addUser(registerObject.getUsername(), registerObject.getPassword());
    }

    @PostMapping("/auth/login")
    public LoginResponseDTO loginUser(@RequestBody RegisterObject body){
        return authService.loginUser(body.getUsername(), body.getPassword());
    }

    //API to delete a book by its ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUserByID(id);
    }

    //API to get details of a book by its id
    @GetMapping("/get_user/{id}")
    public User getUserbyID(@PathVariable Integer id) {
        return userService.getUserByID(id);
    }
}
