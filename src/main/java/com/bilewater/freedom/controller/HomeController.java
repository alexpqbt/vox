package com.bilewater.freedom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bilewater.freedom.entity.Post;

@Controller
public class HomeController {

  @GetMapping("/")
  public String index() {
    return "index";
  }
  
  @GetMapping("/home")
  public String homePage(Model model) {
    model.addAttribute("post", new Post());
    return "home";
  }

  @GetMapping("/{user}/posts")
  public String userPostsPage() {
    return "profile";
  }
}
