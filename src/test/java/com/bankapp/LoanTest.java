package com.bankapp;

import com.bankapp.Dto.LoanDto;
import com.bankapp.Dto.LoanStatus;
import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class LoanTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void loanStatus(){
        LoanDto loanDto = new LoanDto();
        loanDto.setAccountNo("1120002187");
        loanDto.setLoanType("Education Loan");
        loanDto.setDocumentType("Adhaar");
        loanDto.setDocumentDetails("1234567890");
        LoanStatus loanStatus = userService.getLoanStatus(loanDto);
        assertEquals(loanDto.getAccountNo(),loanStatus.getAccountNo());
    }

    @Test
    void loanStatus2(){
        LoanDto loanDto = new LoanDto();
        loanDto.setAccountNo("1120002214");
        loanDto.setLoanType("Education Loan");
        loanDto.setDocumentType("Adhaar");
        loanDto.setDocumentDetails("1234567890");
        LoanStatus loanStatus = userService.getLoanStatus(loanDto);
        assertEquals(loanDto.getAccountNo(),loanStatus.getAccountNo());
    }

}
