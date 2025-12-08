package com.loremipsum.vox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loremipsum.vox.model.User;

public interface UserRepository extends JpaRepository<User, Long> { }
