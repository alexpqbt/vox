package com.bilewater.freedom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilewater.freedom.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByUserUsername(String username);
}
