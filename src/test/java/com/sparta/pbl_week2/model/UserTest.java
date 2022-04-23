package com.sparta.pbl_week2.model;

import com.sparta.pbl_week2.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("정상케이스")
    void check_Test() {

        String user_email = "";
        String user_password = "1234aaaa";
        String user_password_check = "1234aaaa";
        String user_name = "18zzz18";

        UserDto.Request requestDto = new UserDto.Request(
                user_email,
                user_name,
                user_password,
                user_password_check
        );
        //when
        User user = new User(requestDto);
        //then
        assertEquals(user_email, user.getUserEmail());
        assertEquals(user_password, user.getUserPassword());
        assertEquals(user_name, user.getUserName());
    }




}