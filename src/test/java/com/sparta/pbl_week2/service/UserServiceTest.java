//package com.sparta.pbl_week2.service;
//
//import com.sparta.pbl_week2.model.User;
//import org.h2.engine.UserBuilder;
//
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserServiceTest {
//    private static ValidatorFactory validatorFactory;
//    private static Validator validator;
//
//    @org.junit.jupiter.api.BeforeAll
//    static void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.getValidator();
//    }
//
//    @org.junit.jupiter.api.Test
//    void validateUser() {
//        User user = new User();
//        user.setUserName("test");
//    }
//}