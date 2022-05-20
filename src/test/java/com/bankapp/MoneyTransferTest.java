package com.bankapp;

import com.bankapp.Dto.MoneyTransferDto;
import com.bankapp.model.AccountHistory;
import com.bankapp.model.User;
import com.bankapp.repository.AccountHistoryRepository;
import com.bankapp.repository.UserRepository;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class MoneyTransferTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountHistoryRepository accountHistoryRepository;

    @Autowired
    private UserService userService;

    @Test
    void moneyTransfer(){
        MoneyTransferDto moneyTransferDto = new MoneyTransferDto();
        moneyTransferDto.setFromAccount("1120003232");
        moneyTransferDto.setToAccount("1120002237");
        moneyTransferDto.setAmount(100l);
        userService.moneyTransfer("1120002237","1120003232",moneyTransferDto);
        User user = userRepository.getUserByAccountNo("1120003232");
        List accountHistory;
        accountHistory = accountHistoryRepository.getMiniStatement("1120003232");
        AccountHistory accountHistory1 = (AccountHistory) accountHistory.get(accountHistory.size()-1);
        assertEquals(user.getAccountNumber(), accountHistory1.getFromAccount());
//        assertEquals(user.getAccountNumber(), accountHistory1.getToAccount());
//        assertEquals(moneyTransferDto.getAmount(), accountHistory1.getAmount());
    }

}
