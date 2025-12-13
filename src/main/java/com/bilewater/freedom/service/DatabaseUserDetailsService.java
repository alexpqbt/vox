package com.bilewater.freedom.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bilewater.freedom.entity.AppUser;
import com.bilewater.freedom.repository.UserRepository;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {
  private UserRepository userRepository;

  public DatabaseUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

    return User
      .builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRole())
        .build();
  }
  
}
