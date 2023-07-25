package com.information.learninghibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.information.learninghibernate.entities.ContactEntity;

import jakarta.validation.Valid;

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
        model.addAttribute("contact", new ContactEntity());
        return "contact/form.html";
    }
     
    @PostMapping("/contact")
    public String contactSend( @Valid @ModelAttribute(name="contact") ContactEntity contact, BindingResult contactBinding)
    {   

        if (contactBinding.hasErrors()) {
            System.out.println(contactBinding);
             return "contact/form.html";
        }
        System.out.println(contact);
        return "redirect:/";
    }
}
