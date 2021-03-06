package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    @GetMapping("/")
    public String index(Model model,Principal principal){
        if(principal == null){
            model.addAttribute("message","customer");
        }
        else {
            model.addAttribute("message", "hi "+principal.getName());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info (Model model){
        model.addAttribute("message","hi info");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal){
        model.addAttribute("message","hi "+principal.getName());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal){
        model.addAttribute("message","hi admin "+principal.getName());
        return "admin";
    }


    @GetMapping("/access-denied")
    public String accessDenied(Principal principal,Model model){
        model.addAttribute("name",principal.getName());
        return "access-denied";
    }


}
