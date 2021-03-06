package com.sparta.pbl_week2.service;


import com.sparta.pbl_week2.dto.TokenDto;
import com.sparta.pbl_week2.dto.UserDto;
import com.sparta.pbl_week2.exception.*;
import com.sparta.pbl_week2.model.Post;
import com.sparta.pbl_week2.model.User;
import com.sparta.pbl_week2.repository.UserRepository;
import com.sparta.pbl_week2.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";


    public void validateHandling(Errors errors) {
        for (FieldError error : errors.getFieldErrors()) {
            if(error.getField().equals("user_email")){
                throw new InvalidEmail();
            }
            else if(error.getField().equals("user_name")){
                throw new InvalidNickname();
            }
            else if(error.getField().equals("user_password")){
                throw new InvalidPassword();
            }
        }
    }

    @Transactional
    public void registerUser(UserDto.Request requestDto) {

        System.out.println(requestDto.getUser_email());
        System.out.println(requestDto.getUser_name());
        System.out.println(requestDto.getUser_password());
        //비밀번호 확인 입력 검사
        if(!requestDto.getUser_password().equals(requestDto.getUser_password_check())){
            throw new InvalidPasswordCheck();
        }

        // 비밀번호<>닉네임 검사
        if(requestDto.getUser_password().equals(requestDto.getUser_name())){
            throw new InvalidNicknameWithPassword();
        }

        // 회원 ID 중복 확인
        String userEmail = requestDto.getUser_email();
        if (userRepository.findByUserEmail(userEmail).isPresent()) {
            throw new DuplicatedEmail();
        }

        String username = requestDto.getUser_name();
        if (userRepository.findByUserName(username).isPresent()) {
            throw new DuplicatedNickname();
        }


        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getUser_password());
        String email = requestDto.getUser_email();

        User user = new User(new UserDto.Request(email, username, password, password));
        userRepository.save(user);
    }

    @Transactional
    public TokenDto.Response login(UserDto.LoginRequest request) {
        User user = userRepository.findByUserEmail(request.getUser_email())
                .orElseThrow(InvalidLogin::new);
        if (!passwordEncoder.matches(request.getUser_password(), user.getUserPassword())) {
            throw new InvalidLogin();
        }
        String accessToken = jwtTokenProvider.createAccessToken(user.getUserName());
//        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUsername(), user.getRoles());
//        tokenRepository.save(new RefreshToken(refreshToken));

        return TokenDto.Response.builder()
                .token(accessToken)
//                .REFRESH_TOKEN(refreshToken)
                .build();
    }

    @Transactional
    public void logout(HttpServletRequest request){
//        String refreshToken = jwtTokenProvider.resolveRefreshToken(request);
//        tokenRepository.deleteByRefreshToken(refreshToken);
        SecurityContextHolder.clearContext();
    }

}