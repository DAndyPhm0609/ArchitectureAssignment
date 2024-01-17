package Architecture.Assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class SystemController {

    //api to go to register page
    @GetMapping("/auth/register")
    public String registration(){
        return "registerPage";
    }




}