package com.bilewater.freedom.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bilewater.freedom.dto.PostForm;
import com.bilewater.freedom.entity.Post;
import com.bilewater.freedom.repository.PostRepository;

@Controller
public class HomeController {

  private PostRepository postRepository;

  public HomeController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }
  
  @GetMapping("/home")
  public String homePage(Model model) {
    model.addAttribute("postForm", new PostForm());

    List<Post> posts = postRepository.findAll();
    model.addAttribute("posts", posts);
    return "home";
  }

  @GetMapping("/{user}/posts")
  public String userPostsPage() {
    return "profile";
  }

}
