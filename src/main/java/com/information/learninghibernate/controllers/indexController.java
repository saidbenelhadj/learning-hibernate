package com.information.learninghibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Learning Hibernate");
        return "page.html";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title", "Contact");
        return "contact/form.html";
    }
     
    @PostMapping("/contact")
    public String contactSend(){
        return "contact/form.html";
    }
}
