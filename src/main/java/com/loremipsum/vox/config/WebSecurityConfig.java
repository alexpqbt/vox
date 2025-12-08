package com.loremipsum.vox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.loremipsum.vox.service.AuthService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  private AuthService authService;

  public WebSecurityConfig(AuthService authService) {
    this.authService = authService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.addFilterBefore(new UsernameLoggingFilter(), UsernamePasswordAuthenticationFilter.class);
    http
      .authorizeHttpRequests((requests) -> requests
        .requestMatchers("/", "/login", "/register").permitAll()
        .anyRequest().authenticated()
      ) 
      .formLogin((form) -> form
        .loginPage("/login")
        .defaultSuccessUrl("/home", true)
        .permitAll()
      )
      .logout((logout) -> logout.permitAll());

      return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return authService;
  }
}
