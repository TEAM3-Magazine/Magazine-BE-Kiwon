package com.sparta.pbl_week2.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class UserControllerTest extends BaseIntegrationTest {
    @MockBean
    private UserController userController;




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
