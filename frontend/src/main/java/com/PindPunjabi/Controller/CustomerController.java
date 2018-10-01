package com.PindPunjabi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.PindPunjabi.Backend.dao.CustomerRespository;
import com.PindPunjabi.Backend.model.Category;
import com.PindPunjabi.Backend.model.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRespository customerRepository;
	

	@RequestMapping("/login")
	public String  loginpage()
	{
		return "login";
	}
			
	@RequestMapping("/Sign")
	public String  signup(Model model)
	{
		model.addAttribute("customer",new Customer());
		return "SignUp";
	}
	

	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String register(@ModelAttribute("customer") Customer customer){
		System.out.println("add customer");
		customerRepository.addCustomer(customer);
		
		return "login";
		

}
	
}
