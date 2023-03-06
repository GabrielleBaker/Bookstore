package com.example.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.Bookstore.domain.UserRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/booklist", true).permitAll().and().logout().permitAll();
		http.authorizeHttpRequests().requestMatchers("/editbook/**", "/addbook", "/booklist").hasRole("USER")
				.requestMatchers("/editbook/**", "/addbook", "/booklist", "/deletebook/**").hasRole("ADMIN")
				.anyRequest().authenticated().and();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList();
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();

		users.add(user);

		user = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("USER", "ADMIN").build();

		users.add(user);
		//User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		//User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		//UserRepository.save(user1);
		//urepository.save(user2);

		return new InMemoryUserDetailsManager(users);
	}
}
