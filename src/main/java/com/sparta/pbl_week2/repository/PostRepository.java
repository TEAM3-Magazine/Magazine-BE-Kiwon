package com.sparta.pbl_week2.repository;

import com.sparta.pbl_week2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();
//    Optional<Post> findByPostId(String userName);
//    Optional<Post> findByUserEmail(String userEmail);
}