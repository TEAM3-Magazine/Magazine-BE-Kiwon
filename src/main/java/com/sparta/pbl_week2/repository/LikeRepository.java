package com.sparta.pbl_week2.repository;

import com.sparta.pbl_week2.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUser_UserIdAndPost_PostId(Long userId, Long postId);

}