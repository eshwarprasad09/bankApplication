package com.bankapp.controller;

import com.bankapp.Dto.LoanDto;
import com.bankapp.Dto.LoanStatus;
import com.bankapp.model.User;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Loan {

    @Autowired
    private UserService userService;


    @GetMapping("/loan")
    public ResponseEntity<LoanStatus> loanStatus(@RequestBody LoanDto loanDto){
        User user = userService.getUserByAccountNo(loanDto.getAccountNo());
        LoanStatus loanStatus = userService.getLoanStatus(loanDto);
        return new ResponseEntity<LoanStatus>(loanStatus, HttpStatus.OK);
    }

}
