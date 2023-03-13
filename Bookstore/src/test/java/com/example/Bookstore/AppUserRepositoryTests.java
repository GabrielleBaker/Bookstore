package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.domain.AppUser;
import com.example.Bookstore.domain.AppUserRepository;


@SpringBootTest
//must tell test to not replace datasource 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class AppUserRepositoryTests {
	@Autowired
	private AppUserRepository appUserRepo;
//these tests all give an error
	// search test
	@Test
	public void findByUsername() {
		List <AppUser> userList = appUserRepo.findByRole("USER");
		assertThat(userList).hasSize(1);
		assertThat(userList.get(0).getRole()).isEqualTo("USER");
	}

	// create test
	@Test
	public void createNewUser() {
		AppUser appUser = new AppUser("Gabrielle","thisisatestuserpassword","gabrielle@gmail.com","user");
		appUserRepo.save(appUser);
		assertThat(appUser.getId()).isNotNull();
	}

	// delete test
	@Test
	public void deleteAppUser() {
		List<AppUser> appUsers = appUserRepo.findByName("Gabrielle");
		AppUser appUser = appUsers.get(0);
		appUserRepo.delete(appUser);
		List<AppUser> newAppUsers = appUserRepo.findByName("Gabrielle");
		assertThat(newAppUsers).hasSize(0);
	}

}
