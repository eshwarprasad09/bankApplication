package com.bankapp;

import com.bankapp.Dto.BalanceEnquiry;
import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class BalanceEnquiryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void balanceEnquiry(){
        BalanceEnquiry balanceEnquiry = userService.getBalance("1120002187");
        assertEquals(java.util.Optional.ofNullable(balanceEnquiry.getBalance()),java.util.Optional.ofNullable(1000l));
    }

}
