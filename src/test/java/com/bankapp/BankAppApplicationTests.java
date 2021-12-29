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
