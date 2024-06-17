package com.example.angularLogin.dtos.request;

import jakarta.validation.constraints.Email;

import java.util.Set;

public class RegisterUserDto
{
  @Email
  private String email;
  private Set<String> role;
  private String password;

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
