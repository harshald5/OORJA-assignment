package com.oorjaa.ShopApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oorjaa.ShopApp.Model.Products;
import com.oorjaa.ShopApp.Service.ProductsService;
import com.oorjaa.ShopApp.Service.ProductsServiceImpl;

@RequestMapping("/product")
@RestController
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	//API to Add products in database
	@PostMapping("/save") 
	public String saveUser(@RequestBody Products products) {
		productsService.saveProducts(products);
		return "success";
	}
	
	//To display available product
	@GetMapping("/showAll")
	public List<Products> showAll()
	{
		return productsService.allproduct();
	}

}
