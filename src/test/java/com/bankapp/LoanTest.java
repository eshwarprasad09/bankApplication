package com.bankapp;

import com.bankapp.Dto.LoanStatus;
import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class LoanTest {

    @Autowired
    private UserRepository userRepository;


    public Boolean isAccountExists(String accountNo) {
        User user = userRepository.getUserByAccountNo(accountNo);
        return user != null;
    }

    @Test
    void loanStatus(){
        User user = userRepository.getUserByAccountNo("1120003232");
        LoanStatus loanStatus = new LoanStatus();
        if (isAccountExists("1120003232")) {
            loanStatus.setAccountNo("1120003232");
            loanStatus.setLoanType("Education Loan");
            loanStatus.setAmount(1000l);
            if(user.getBalance() > 600){
                loanStatus.setLoanStatus("Approved");
            }
            else{
                loanStatus.setLoanStatus("Not Approved");
            }
        }
        loanStatus.setLoanStatus("Not approved Account Not Exists");
        LoanStatus loanStatus1 = new LoanStatus();
        loanStatus1.setAccountNo("1120003232");
        loanStatus1.setLoanType("Education Loan");
        loanStatus1.setAmount(1000l);
        loanStatus1.setLoanStatus("Approved");
        assertEquals(loanStatus1.getAccountNo(),loanStatus.getAccountNo());
    }

}
