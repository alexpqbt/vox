package com.bilewater.freedom.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterForm {
  @NotBlank
  private String username;

  @NotBlank 
  private String password;

  @NotBlank
  private String confirmPassword;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }


}
