package com.loremipsum.vox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loremipsum.vox.model.User;


@Controller
public class RegisterController {

  @GetMapping("/register")
  public String registerForm() {
    return "register.html";
  }

  @PostMapping("/register")
  public String userRegister(@ModelAttribute User user, Model model) {
    model.addAttribute("user", user);
    return "home";
  }
  
}
