package com.packt.siuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.siuo.domain.User;
import com.packt.siuo.domain.repository.UserRepository;
import com.packt.siuo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
		//return userRepository.findAll();
	}
}
