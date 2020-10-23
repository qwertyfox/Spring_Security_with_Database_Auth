package com.qwertyfox.encrypted_password.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/")
public class TemplateController {

    @RequestMapping("/login")
    public String test() {
        System.out.println("TEST /");
        return "login.jsp";
    }

    @RequestMapping("/welcome")
    public String getWelcome() {
        return "welcome.jsp";
    }
}
