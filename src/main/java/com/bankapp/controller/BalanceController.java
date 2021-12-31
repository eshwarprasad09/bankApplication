package com.bankapp.controller;

import com.bankapp.Dto.BalanceEnquiry;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @Autowired
    private UserService userService;

    @GetMapping("/getbalance/{accountNo}")
    public ResponseEntity<BalanceEnquiry> getBalance(@PathVariable("accountNo") String accountNo) {
        if (!userService.isAccountExists(accountNo)) {
            return new ResponseEntity<BalanceEnquiry>(HttpStatus.BAD_REQUEST);
        }
        BalanceEnquiry balance = userService.getBalance(accountNo);
        return new ResponseEntity<BalanceEnquiry>(balance, HttpStatus.ACCEPTED);
    }

}
