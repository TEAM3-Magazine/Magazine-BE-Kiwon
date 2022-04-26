package com.sparta.pbl_week2.model;

import com.sparta.pbl_week2.dto.UserDto;
import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

}

//
//
//    @Test
//    @DisplayName("정상 케이스")
//    void testUserDto() {
//        //given
//        String user_email = "funnykyeon@naver.com";
//        String user_name = "8282";
//        String user_password = "1234aaaa";
//        String user_password_check = "1234aaaa";
//
//        //when
//        UserDto.Request userDto = new UserDto.Request(user_email, user_name, user_password, user_password_check);
//
//        //then
//        assertEquals(user_email, userDto.getUser_email());
//        assertEquals(user_name, userDto.getUser_name());
//        assertEquals(user_password, userDto.getUser_password());
//        assertEquals(user_password_check, userDto.getUser_password_check());
//    }
//}
//
//
//








//    @Test
//    @DisplayName("정상케이스")
//    void check_Test() {
//
//        String user_email = "funnykyeon@naver.com";
//        String user_password = "1234aaaa";
//        String user_password_check = "1234aaaa";
//        String user_name = "18zzz18";
//
//        UserDto.Request request = new UserDto.Request(
//                user_email,
//                user_name,
//                user_password,
//                user_password_check
//        );
//        //when
//        User user = new User(request);
//
//        // then
//        assertNull(user.getUserId());
//        assertEquals(user_email, user.getUserEmail());
//        assertEquals(user_name, user.getUserName());
//        assertEquals(user_password, user.getUserPassword());
//    }
//
//}
