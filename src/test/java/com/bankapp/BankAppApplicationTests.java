package com.bankapp;

import com.bankapp.Dto.LoanStatus;
import com.bankapp.Dto.LoginDto;
import com.bankapp.Dto.UserAccount;
import com.bankapp.model.AccountHistory;
import com.bankapp.model.Role;
import com.bankapp.model.User;
import com.bankapp.repository.AccountHistoryRepository;
import com.bankapp.repository.RoleRepository;
import com.bankapp.repository.UserRepository;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class BankAppApplicationTests {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountHistoryRepository accountHistoryRepository;

	@Test
	void openAccount() {
		User user = new User();
		user.setName("Eshwarprasad");
		user.setEmail("eshwarprasad20@gmail.com");
		user.setPassword("123456789");
		user.setBalance(1000L);
		user.setAccountNumber("1");

		Role roleUser = roleRepository.findByName("user");
		user.addRole(roleUser);

		userService.saveUser(user);

		User user1 = userRepository.getUserByLogin("eshwarprasad20@gmail.com","123456789");

		assertEquals(user.getEmail(), user1.getEmail());
	}

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

	@Test
	void login(){
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail("eshwarprasadishere123@gmai.com");
		loginDto.setPassword("1234567890");
		User user = userService.getLogin(loginDto);
		assertEquals(user.getEmail(),"eshwarprasadishere123@gmai.com");
	}


	@Test
	void balanceEnquiry(){
		Long balance = userRepository.getBalance("1120003232");
		assertEquals(java.util.Optional.ofNullable(balance),java.util.Optional.ofNullable(2400l));
	}

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
