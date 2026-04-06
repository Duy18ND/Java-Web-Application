package org.example.demo_mvc.controller.new_way;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScriptletController {
    @GetMapping({"/","/scriptlet"})
    public String scriptlet(){
        return "scriptlet";
    }
}
