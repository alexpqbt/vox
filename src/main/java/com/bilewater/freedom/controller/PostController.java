package com.bilewater.freedom.controller;

import java.security.Principal;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bilewater.freedom.dto.PostForm;
import com.bilewater.freedom.entity.AppUser;
import com.bilewater.freedom.entity.Post;
import com.bilewater.freedom.repository.PostRepository;
import com.bilewater.freedom.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class PostController {

  private PostRepository postRepository;
  private UserRepository userRepository;

  public PostController(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @PostMapping("/add-post")
  public String addPost(@Valid @ModelAttribute("postForm") PostForm form, BindingResult result, Model model, Principal principal) {
    if (result.hasErrors()) {
      model.addAttribute("posts", postRepository.findAll());
      return "home";
    }
    
    String username = principal.getName();
    AppUser user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    Post post = new Post();
    post.setTitle(form.getTitle());
    post.setBody(form.getBody());
    post.setUser(user);
    postRepository.save(post);
    return "redirect:/home";
  }
  
}
