package com.oorjaa.ShopApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oorjaa.ShopApp.Model.Customer;
import com.oorjaa.ShopApp.Model.Products;
import com.oorjaa.ShopApp.Service.CustomerService;
import com.oorjaa.ShopApp.Service.CustomerServiceImpl;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//API to add customer
	@PostMapping("/savecust")
	public String addUser(@RequestBody Customer customer) {
	 customerService.saveUser(customer);
	 return "success";
	}

}
