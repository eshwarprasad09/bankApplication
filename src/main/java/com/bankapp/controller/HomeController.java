package com.bankapp.controller;

import com.bankapp.Dto.*;
import com.bankapp.model.Role;
import com.bankapp.model.User;
import com.bankapp.repository.AccountHistoryRepository;
import com.bankapp.repository.RoleRepository;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountHistoryRepository accountHistoryRepository;

    @GetMapping("/")
    public String home(){
        return "Welcome to HSBC Bank";
    }


    @GetMapping("/getuser/{accountNo}")
    public ResponseEntity<User> getUser(@PathVariable("accountNo") String accountNo){
        User user = userService.getUserByAccountNo(accountNo);
        return new ResponseEntity<User>(user, HttpStatus.FOUND);
    }

    //checked out feature branch eshwarprasad
    //checked out feature branch eshwarprasad one more time

//    checked out sprint
    //checked out feature

    //checked out feature branch
    //checkout

}