package Architecture.Assignment.controller;

import Architecture.Assignment.model.RegisterObject;
import Architecture.Assignment.model.User;

import Architecture.Assignment.model.UserRole;
import Architecture.Assignment.repo.RolesRepo;
import Architecture.Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RolesRepo rolesRepo;

    @GetMapping("/user/home")
    public String home() {
        return ("Hello user");
    }

    @GetMapping("/admin/home")
    public String secured() {
        return ("Hello admin");
    }

    @GetMapping("/auth/users")
    public List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/auth/roles")
    public List<UserRole> getRoles(){ return rolesRepo.findAll();}

    @PostMapping("/auth/add_user")
    public User addUser(@RequestBody RegisterObject registerObject) {
        return userService.addUser(registerObject.getUsername(), registerObject.getPassword());
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