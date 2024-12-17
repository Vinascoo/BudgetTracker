package com.matteus.budgettracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Budget Tracker!");
        return "home";
    }
}
