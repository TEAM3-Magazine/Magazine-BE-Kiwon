package com.sparta.pbl_week2.controller;

import com.sparta.pbl_week2.exception.NotFoundAuth;
import com.sparta.pbl_week2.model.User;
import com.sparta.pbl_week2.repository.LikeRepository;
import com.sparta.pbl_week2.responseEntity.ResponseBody;
import com.sparta.pbl_week2.security.UserDetailsImpl;

import com.sparta.pbl_week2.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likesService;
    private final LikeRepository likeRepository;


    @PostMapping("/api/post/{postId}/like")
    public ResponseEntity<ResponseBody> likeBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        User user = userDetails.getUser();
        if(user.getUserName().equals("x")){
            throw new NotFoundAuth();
        }
        likesService.addlikes(user.getUserId(), postId);
        return new ResponseEntity<>(new ResponseBody("success","좋아요를 생성했습니다"), HttpStatus.OK);
    }

    @DeleteMapping("/api/post/{postId}/like")
    public ResponseEntity<ResponseBody> cancelLikeBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        User user = userDetails.getUser();
        if(user.getUserName().equals("x")){
            throw new NotFoundAuth();
        }
        likesService.delete(user.getUserId(), postId);
        return new ResponseEntity<>(new ResponseBody("success","좋아요를 취소했습니다"), HttpStatus.OK);
    }

}