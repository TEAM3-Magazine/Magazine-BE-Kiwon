package com.sparta.pbl_week2.controller;

import com.sparta.pbl_week2.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@DisplayName("회원가입 테스트")
class UserControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("회원가입 성공")
    void createUser() throws Exception {
        UserDto userDto = new UserDto();

    }
}

//    @Test
//    @DisplayName("로그인 테스트")
//    void login() {
//        UserController userController = new UserController();
//        userController.login();
//    }
//
//    @Test
//    @DisplayName("로그아웃 테스트")
//    void logout() {
//        UserController userController = new UserController();
//        userController.logout();
//    }
//}
