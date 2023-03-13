package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	AppUser findById(long id);
	AppUser findByUsername(String username);
	List<AppUser> findByName(@Param("username") String username);
	List<AppUser> findByRole(@Param("role") String role);
}
