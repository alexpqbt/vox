package com.loremipsum.vox.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loremipsum.vox.model.User;
import com.loremipsum.vox.repository.UserRepository;

@Service
public class AuthService {
  private UserRepository userRepo;
  
  public AuthService(UserRepository userRepository) {
    this.userRepo = userRepository;
  }

  public boolean checkAccount(User user) {
    String username = user.getUsername();
    String password = user.getPassword();

    Optional<User> foundUser = userRepo.findByUsername(username);
    return foundUser
              .map(fuser -> password.equals(fuser.getPassword()))
              .orElse(false);
  }

  public boolean usernameExists(String username) {
    return userRepo.existsByUsername(username);
  }

  public User registerUser(User user) {
    String username = user.getUsername();
    String password = user.getPassword();

    if (usernameExists(username)) {
      throw new IllegalArgumentException("Username already exists");
    }

    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);

    return userRepo.save(newUser);
  }
}
