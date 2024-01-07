package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

    @GetMapping("/register")
    public String registration(){
        return "registerPage";
    }
}