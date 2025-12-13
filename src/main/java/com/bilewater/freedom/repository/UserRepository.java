package com.bilewater.freedom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilewater.freedom.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
  Optional<AppUser> findByUsername(String username);
}
