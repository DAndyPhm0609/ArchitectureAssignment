package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SystemController {
    @GetMapping("/registration")
    public String registration(){
        return ("register");
    }

    @GetMapping("/registration_confirm")
    public String registration_confirm(){
        return ("registration_confirm");
    }
}
