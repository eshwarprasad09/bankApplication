package com.bankapp;

import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class BalanceEnquiryTest {

    @Autowired
    private UserRepository userRepository;

    public Boolean isAccountExists(String accountNo) {
        User user = userRepository.getUserByAccountNo(accountNo);
        return user != null;
    }

    @Test
    void balanceEnquiry(){
        Long balance = userRepository.getBalance("1120002187");
        assertEquals(java.util.Optional.ofNullable(balance),java.util.Optional.ofNullable(1000l));
    }

}
