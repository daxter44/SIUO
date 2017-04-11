package com.packt.siuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.siuo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
		@RequestMapping("/users")
		public String list(Model model){
			model.addAttribute("users", userService.getAllUsers());
			return "users";
		}
	

}
