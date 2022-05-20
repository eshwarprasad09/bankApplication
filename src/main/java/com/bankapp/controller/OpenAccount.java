package com.bankapp.controller;

import com.bankapp.Dto.UserDto;
import com.bankapp.model.User;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAccount {

    @Autowired
    private UserService userService;

    @PostMapping("/openaccount")
    public ResponseEntity<User> openAccount(@RequestBody UserDto userDto){
        User user = userService.openAccount(userDto);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

}
//jenkins
//updatedProject