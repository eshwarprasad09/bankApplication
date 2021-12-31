package com.bankapp;

import com.bankapp.model.AccountHistory;
import com.bankapp.model.User;
import com.bankapp.repository.AccountHistoryRepository;
import com.bankapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class MoneyTransferTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountHistoryRepository accountHistoryRepository;

    public Boolean isAccountExists(String accountNo) {
        User user = userRepository.getUserByAccountNo(accountNo);
        return user != null;
    }

    @Test
    void moneyTransfer(){
        if (isAccountExists("1120003232")) {
            User fromUser = userRepository.getUserByAccountNo("1120003232");
            fromUser.setBalance(fromUser.getBalance() - 100);
            userRepository.save(fromUser);
        }

        if (isAccountExists("1120002237")) {
            User toUser = userRepository.getUserByAccountNo("1120002237");
            toUser.setBalance(toUser.getBalance() + 100);
            userRepository.save(toUser);
        }

        User user = userRepository.getUserByAccountNo("1120003232");
        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setToAccount("1120002237");
        accountHistory.setFromAccount("1120003232");
        accountHistory.setAmount(100l);
        accountHistory.setUserId(2l);
        AccountHistory accountHistory1 = accountHistoryRepository.save(accountHistory);
        assertEquals(accountHistory,accountHistory1);
    }

}
