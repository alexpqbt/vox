package com.bilewater.freedom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilewater.freedom.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  
}
