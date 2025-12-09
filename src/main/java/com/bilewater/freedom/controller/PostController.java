package com.bilewater.freedom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bilewater.freedom.entity.Post;
import com.bilewater.freedom.repository.PostRepository;

@Controller
@RequestMapping("/api")
public class PostController {

  private PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @PostMapping("/add-post")
  public String addPost(@ModelAttribute Post post) {
    postRepository.save(post);
    return "redirect:/home";
  }
  
}
