package com.sparta.pbl_week2.controller;

import com.sparta.pbl_week2.dto.UserDto;
import com.sparta.pbl_week2.model.User;
import org.junit.jupiter.api.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Disabled
@Transactional
@SpringBootTest
@AutoConfigureAfter
class UserControllerTest {

    @Nested
    @DisplayName("새로운 유저 생성")
    class createUser {

        // given
        private String user_name;
        private String user_email;
        private String user_password;
        private String user_password_check;

        @BeforeEach
        void setup() {
            // when
            user_email = "1818test@naver.com";
            user_name = "test";
            user_password = "test1234";
            user_password_check = "test1234";
        }

        @Test
        @DisplayName("정상케이스")
        void createUser_normal() {
            //guven
            String uesr_password = user_password_check;
            UserDto.Request userDto = new UserDto.Request(
                    user_name,
                    user_email,
                    user_password,
                    user_password_check
            );

            // when
            User user = User.builder()
                    .user_name(userDto.getUser_name())
                    .user_email(userDto.getUser_email())
                    .user_password(userDto.getUser_password())
                    .build();

            //then
            assertNull(user.getUserId());
            assertEquals(user_name, user.getUserName());
            assertEquals(user_email, user.getUserEmail());
            assertEquals(user_password, user.getUserPassword());

        }
    }
}


//    @Builder
//    public User(UserDto.Request request) {
//        this.userEmail = request.getUser_email();
//        this.userName = request.getUser_name();
//        this.userPassword = request.getUser_password();
//        this.userPasswordCheck = request.getUser_password_check();
//    void registerUser() {
//
//    }
//
//    @Test
//    void getUserInfo() {
//    }
//
//    @Test
//    void login() {
//    }
//
//    @Test
//    void logout() {
//    }
