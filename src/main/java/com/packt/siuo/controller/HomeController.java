package com.packt.siuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Witaj w aplikacji SIUO");
		model.addAttribute("tagline", "SprawdŸ swoj¹ wiedzê ! :)");
		return "welcome";
	}
}
