package Architecture.Assignment.controller;

import Architecture.Assignment.model.User;

import Architecture.Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return ("Hello home");
    }

    @GetMapping("/secured")
    public String secured() {
        return ("Hello secured");
    }

    @GetMapping("/auth/users")
    public List<User> getUsers() {
        return userService.getUser();
    }

    @PostMapping("/auth/add_user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
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