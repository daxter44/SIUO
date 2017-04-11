package com.packt.siuo.domain.repository;

import java.util.List;

import com.packt.siuo.domain.User;

public interface UserRepository {
	
	List<User> getAllUsers();
}
