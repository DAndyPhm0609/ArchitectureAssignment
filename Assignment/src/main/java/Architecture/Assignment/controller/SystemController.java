package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

    @GetMapping("/auth/register")
    public String registration(){
        return "registerPage";
    }

    @GetMapping("/auth/login")
    public String login() {
        return "login";
    }
}