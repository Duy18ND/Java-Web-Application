package org.example.demo_mvc.controller.new_way;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody; // Nhớ import cái này

@Controller
public class GreetingController {

    @GetMapping({"/", "/greeting"})
    public String greeting(){
        return "greeting";
    }
}