package com.loremipsum.vox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterController {

  @GetMapping("/register")
  public String registerForm() {
    return "register.html";
  }

  @PostMapping("/register")
  public void userRegister(@RequestBody String entity) {
    System.out.println(entity);    
  }

}
