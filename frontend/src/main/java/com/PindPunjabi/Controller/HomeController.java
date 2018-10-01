package com.PindPunjabi.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/Home")
	
		public String indexpage(HttpSession session,Model model)
		{		
		
		model.addAttribute("title","HomePage");
		return "index";
	}
	

	@RequestMapping("/")
	public String  homepage()
	{
		return "index";
	}
			
	@RequestMapping("/Admin")
		
		public String Adminhome()
		{
		
			return "Admin";
		
		}
}
