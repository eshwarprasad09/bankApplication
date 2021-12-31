package com.bankapp;

import com.bankapp.Dto.UserAccount;
import com.bankapp.model.User;
import com.bankapp.repository.AccountHistoryRepository;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class AccountHistoryTest {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountHistoryRepository accountHistoryRepository;

    @Test
    void accountHistory(){
        List accountHistoryList = accountHistoryRepository.getMiniStatement("1120003232");
        User user = userService.getUserByAccountNo("1120003232");
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountNo(user.getAccountNumber());
        userAccount.setName(user.getName());
        userAccount.setBalance(user.getBalance());
        accountHistoryList.add(0,userAccount);
        assertEquals(accountHistoryList.get(0),userAccount);
    }

}
