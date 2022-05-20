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
        List accountHistory = userService.getAccountHistory("1120002237");
        UserAccount user = (UserAccount) accountHistory.get(0);
        assertEquals("1120002237", user.getAccountNo());
    }

}
