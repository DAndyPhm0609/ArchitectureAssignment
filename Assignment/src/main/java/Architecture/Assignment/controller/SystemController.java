package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("http://localhost:5173/")
public class SystemController {

    //api to go to register page
    @GetMapping("/auth/register")
    public String registration(){
        return "registerPage";
    }

    //Api to go to login page
    @GetMapping("/auth/loginPage")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/user/home")
    public String home() {
        return ("Hello user");
    }

    @GetMapping("/admin/home")
    public String secured() {
        return ("Hello admin");
    }
}