package com.bankapp;

import com.bankapp.Dto.LoginDto;
import com.bankapp.model.User;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class LoginTest {

    @Autowired
    private UserService userService;

    @Test
    void login(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("eshwarprasadishere123@gmai.com");
        loginDto.setPassword("1234567890");
        User user = userService.getLogin(loginDto);
        assertEquals(user.getEmail(),"eshwarprasadishere123@gmai.com");
    }

}
