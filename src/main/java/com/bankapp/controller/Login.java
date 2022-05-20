package com.bankapp.controller;

import com.bankapp.Dto.LoginDto;
import com.bankapp.model.Role;
import com.bankapp.model.User;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class Login {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        User user = userService.getLogin(loginDto);
        if(user != null){
            Set<Role> roles = user.getRoles();
            for(Role role : roles){
                return role.getName() + " Login Success";
            }
            return "Login Success";
        }
        else{
            return "Invalid user";
        }
    }

}
