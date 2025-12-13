package com.bilewater.freedom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bilewater.freedom.entity.Post;
import com.bilewater.freedom.repository.PostRepository;

@Controller
public class ProfileController {

  private PostRepository postRepository;
  
  public ProfileController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping("/{user}/posts")
  public String userPostsPage(Principal principal, Model model) {
    List<Post> posts = postRepository.findByUserUsername(principal.getName());
    model.addAttribute("posts", posts);
    return "profile";
  }

}
