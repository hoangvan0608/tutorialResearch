package com.example.tutorial.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeFController {

    @GetMapping({"","/home","/"})
    public String homePage() {
        return "frontend/homePage";
    }
}
