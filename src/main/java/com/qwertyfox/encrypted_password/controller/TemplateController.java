package com.qwertyfox.encrypted_password.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

    @RequestMapping("/welcome")
    public String getWelcome() {
        return "welcomePage.html";
    }


}
