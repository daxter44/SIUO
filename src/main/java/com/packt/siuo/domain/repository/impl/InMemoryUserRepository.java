package com.packt.siuo.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.User;
import com.packt.siuo.domain.repository.UserRepository;


@Repository
public class InMemoryUserRepository implements UserRepository {

	private List<User> listOfUsers = new ArrayList<User>();
	
	public InMemoryUserRepository(){
		User user1 = new User(1, "Kamil", "Kowalski", "Informatyka", 1 );
		User user2 = new User(2, "Natalia", "Kamiñska", "Informatyka lic", 3 );
		
		listOfUsers.add(user1);
		listOfUsers.add(user2);		
	}
	
	public List<User> getAllUsers(){
		return listOfUsers;
	}
	
}
