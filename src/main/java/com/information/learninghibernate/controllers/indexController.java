package com.information.learninghibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.information.learninghibernate.entities.ContactEntity;
import com.information.learninghibernate.services.ContactService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class indexController {
    private final ContactService contactService;

    public indexController(ContactService contactService) {
        this.contactService = contactService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Learning Hibernate");
        model.addAttribute("contacts", contactService.findAll());
        return "page";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title", "Contact");
        model.addAttribute("contact", new ContactEntity());
        return "contact/form.html";
    }
     
    @PostMapping("/contact")
    public String contactSend( 
        @Valid @ModelAttribute(name="contact") ContactEntity contact, 
        BindingResult contactBinding,
        Model model
        )
    {   
        if (contactBinding.hasErrors()) {
            System.out.println(contactBinding);
             return "contact/form.html";
        }try {
            contactService.save(contact);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("contact", contact);
            model.addAttribute("emailError", "l'email existe déjà");
            return "redirect:/form";
        }
        
        return "redirect:/";
    }
    @GetMapping("/contact/{id}/delete")
    public String contactDelete(@PathVariable Integer id,
                                RedirectAttributes redirectAttributes) {
        if (id != null) {
            if (id > 0) {
                contactService.deleteByid(id);
                redirectAttributes.addFlashAttribute("message", "Le contact a bien été supprimé");
            } else {
                redirectAttributes.addFlashAttribute("message", "Je ne connais ce contact");
            }
        }
        return "redirect:/";
    }
}
