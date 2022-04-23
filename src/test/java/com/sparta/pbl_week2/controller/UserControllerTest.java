//package com.sparta.pbl_week2.controller;
//
//import com.sparta.pbl_week2.dto.UserDto;
//import com.sparta.pbl_week2.model.User;
//import org.junit.jupiter.api.*;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//@Disabled
//@Transactional
//@SpringBootTest
//@AutoConfigureAfter
//class UserControllerTest {
//    private UserController userController;
//
//    @BeforeEach
//    void setUp() {
//        userController = new UserController();
//    }
//
//    @Test
//    void testGetUser() {
//        UserDto userDto = userController.getUser(1);
//        assertEquals("John", userDto.getFirstName());
//        assertEquals("Doe", userDto.getLastName());
//        assertEquals("
//
//}