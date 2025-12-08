package com.loremipsum.vox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loremipsum.vox.model.User;
import com.loremipsum.vox.service.AuthService;

@Controller
public class AuthController {
  private AuthService authService;
  
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @GetMapping({ "/", "/login" })
  public String loginForm() {
    return "login";
  }

  @GetMapping("/register")
  public String registerForm() {
    return "register";
  }

  @PostMapping("/register")
  public String userRegister(@ModelAttribute User user) {
    authService.registerUser(user);
    return "redirect:/login";
  }
}
