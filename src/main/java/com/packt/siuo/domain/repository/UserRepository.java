package com.packt.siuo.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.packt.siuo.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	//List<User> getAllUsers();
}
