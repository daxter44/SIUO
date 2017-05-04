package com.packt.siuo.service;

import java.util.List;

import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.User;

public interface UserService {

	Iterable<User> getAllUsers();
}
