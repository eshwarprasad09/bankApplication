package com.bankapp.controller;

import com.bankapp.Dto.MoneyTransferDto;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyTransfer {

    @Autowired
    private UserService userService;

    @PostMapping("/moneytransfer")
    public String moneyTransfer(@RequestBody MoneyTransferDto moneyTransferDto){
        String toAccount = moneyTransferDto.getToAccount();
        String fromAccount = moneyTransferDto.getFromAccount();
        userService.moneyTransfer(toAccount, fromAccount, moneyTransferDto);
        return "Transfer Success";
    }

}
