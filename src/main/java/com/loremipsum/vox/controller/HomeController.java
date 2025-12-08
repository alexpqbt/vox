package com.loremipsum.vox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loremipsum.vox.model.Post;


@Controller
public class HomeController {

  @GetMapping("/home")
  public String homePage(Model model) {
    model.addAttribute("post", new Post());
    return "home";
  }
}
