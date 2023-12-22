package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SystemController {
    @GetMapping("/register")
    public String register(){
        return ("register");
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String password,
                               @RequestParam(defaultValue = "false") boolean subscription,
                               Model model){
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        model.addAttribute("subscription", subscription);

        return "registration-confirmation";
    }
}
