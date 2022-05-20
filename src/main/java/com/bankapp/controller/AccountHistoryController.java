package com.bankapp.controller;

import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountHistoryController {

    @Autowired
    private UserService userService;

    @GetMapping("/accounthistory/{accountNo}")
    public ResponseEntity<List> getAccountHistory(@PathVariable("accountNo") String accountNo){
        List accountHistory = userService.getAccountHistory(accountNo);
        return new ResponseEntity<List>(accountHistory, HttpStatus.FOUND);
    }
    
}
