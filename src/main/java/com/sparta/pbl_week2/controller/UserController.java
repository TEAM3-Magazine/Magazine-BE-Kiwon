package com.sparta.pbl_week2.controller;


import com.sparta.pbl_week2.dto.PostDto;
import com.sparta.pbl_week2.dto.TokenDto;
import com.sparta.pbl_week2.dto.UserDto;
import com.sparta.pbl_week2.exception.DuplicatedLogin;
import com.sparta.pbl_week2.exception.NotFoundAuth;
import com.sparta.pbl_week2.exception.RestException;
import com.sparta.pbl_week2.model.Post;
import com.sparta.pbl_week2.model.User;
import com.sparta.pbl_week2.responseEntity.ResponseBody;
import com.sparta.pbl_week2.responseEntity.TokenBody;
import com.sparta.pbl_week2.security.UserDetailsImpl;
import com.sparta.pbl_week2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<ResponseBody> registerUser(@Valid @RequestBody UserDto.Request requestDto, Errors errors) {
        userService.validateHandling(errors);
        userService.registerUser(requestDto);
        return new ResponseEntity<>(new ResponseBody("success", "회원 가입 성공"), HttpStatus.OK);
    }

    //     회원 관련 정보 받기
    @GetMapping("/user/userinfo")
    public ResponseEntity<UserDto.Response> getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        if (user.getUserName().equals("x")) {
            throw new NotFoundAuth();
        }
        Long userId = user.getUserId();
        String userEmail = user.getUserEmail();
        String userName = user.getUserName();
        return new ResponseEntity<>(new UserDto.Response(userId, userEmail, userName), HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<TokenBody> login(@RequestBody UserDto.LoginRequest loginRequest, HttpServletResponse response, Errors errors, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            throw new DuplicatedLogin();
        }

        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                throw new RestException(HttpStatus.BAD_REQUEST, error.getDefaultMessage());
            }
        }

        TokenDto.Response token = userService.login(loginRequest);

        response.setHeader("Authorization", "Bearer " + token.getToken());
//        response.setHeader("REFRESH_TOKEN", token.getREFRESH_TOKEN());


        return new ResponseEntity<>(new TokenBody("success", "로그인 성공", token.getToken()), HttpStatus.OK);
    }

    @PostMapping("/user/logout")
    public ResponseEntity<ResponseBody> logout(HttpServletRequest request) {
//        동작 안함
        userService.logout(request);
        return new ResponseEntity<>(new ResponseBody("success", "로그아웃 성공"), HttpStatus.OK);
    }
}