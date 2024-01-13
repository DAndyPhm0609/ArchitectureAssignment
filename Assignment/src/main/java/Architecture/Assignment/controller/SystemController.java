package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

    //api to go to register page
    @GetMapping("/auth/register")
    public String registration(){
        return "registerPage";
    }

    //Api to go to login page
    @GetMapping("/auth/login")
    public String login() {
        return "login";
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