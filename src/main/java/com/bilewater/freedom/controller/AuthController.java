package com.bilewater.freedom.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bilewater.freedom.dto.RegisterForm;
import com.bilewater.freedom.entity.AppUser;
import com.bilewater.freedom.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }
  
  @GetMapping("/register")
  public String registerPage(Model model) {
    model.addAttribute("form", new RegisterForm());
    return "register";
  }

  @PostMapping("/register")
  public String registerSubmit(@Valid @ModelAttribute("form") RegisterForm form, BindingResult result) {
    if (!form.getPassword().equals(form.getConfirmPassword())) {
      result.rejectValue("confirmPassword", "mismatch", "Password do not match");
    }

    if (userRepository.findByUsername(form.getUsername()).isPresent()) {
      result.rejectValue("username", "exists", "Username already taken");
    }

    if (result.hasErrors()) {
      return "register";
    }

    AppUser user = new AppUser();
    user.setUsername(form.getUsername());
    user.setPassword(passwordEncoder.encode(form.getPassword()));
    user.setRole("USER");

    userRepository.save(user);

    return "redirect:/login";
  }
  
}
