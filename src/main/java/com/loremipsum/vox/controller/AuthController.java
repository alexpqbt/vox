package com.loremipsum.vox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.loremipsum.vox.model.User;
import com.loremipsum.vox.service.AuthService;

@Controller
public class AuthController {
  private AuthService authService;
  
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @GetMapping({ "/", "/login" })
  public String loginForm(Model model) {
    model.addAttribute("user", new User());
    return "login";
  }

  @PostMapping("/login")
  public String userLogin(@ModelAttribute User user, RedirectAttributes attrs) {

    if (!authService.checkAccount(user)) {
      return "login";
    }

    attrs.addFlashAttribute("user", user);
    return "redirect:/home";
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
