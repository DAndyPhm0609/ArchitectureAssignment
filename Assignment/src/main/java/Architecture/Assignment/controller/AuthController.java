package Architecture.Assignment.controller;
import Architecture.Assignment.model.LoginObject;
import Architecture.Assignment.model.RegisterObject;
import Architecture.Assignment.model.User;
import Architecture.Assignment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterObject body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginObject loginUser(@RequestBody RegisterObject body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}