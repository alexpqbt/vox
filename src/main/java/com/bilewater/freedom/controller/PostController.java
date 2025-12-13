package com.bilewater.freedom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bilewater.freedom.dto.PostForm;
import com.bilewater.freedom.entity.Post;
import com.bilewater.freedom.repository.PostRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class PostController {

  private PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @PostMapping("/add-post")
  public String addPost(@Valid @ModelAttribute("postForm") PostForm form, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("posts", postRepository.findAll());
      return "home";
    }
    
    Post post = new Post();
    post.setTitle(form.getTitle());
    post.setBody(form.getBody());
    postRepository.save(post);
    return "redirect:/home";
  }
  
}
