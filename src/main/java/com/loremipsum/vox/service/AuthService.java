package com.loremipsum.vox.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loremipsum.vox.model.User;
import com.loremipsum.vox.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {
  private UserRepository userRepo;
  private PasswordEncoder passwordEncoder;
  
  public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("Login attempt for: " + username);
    User user = userRepo.findByUsername(username)
                  .orElseThrow(() -> new UsernameNotFoundException("Username not found."));

    return org.springframework.security.core.userdetails.User.builder()
              .username(user.getUsername())
              .password(user.getPassword())
              .roles("USER")
              .build();
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

    user.setPassword(passwordEncoder.encode(password));
    return userRepo.save(user);
  }
}
