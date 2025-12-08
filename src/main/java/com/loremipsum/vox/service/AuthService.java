package com.loremipsum.vox.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loremipsum.vox.model.User;
import com.loremipsum.vox.repository.UserRepository;

@Service
public class AuthService {
  private UserRepository userRepository;
  
  @Autowired
  public AuthService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean checkAccount(User user) {
    String username = user.getUsername();
    String password = user.getPassword();

    Optional<User> foundUser = userRepository.findByUsername(username);
    return foundUser
              .map(fuser -> password.equals(fuser.getPassword()))
              .orElse(false);
  }

  public boolean usernameExists(String username) {
    return userRepository.existsByUsername(username);
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

    return userRepository.save(newUser);
  }
}
