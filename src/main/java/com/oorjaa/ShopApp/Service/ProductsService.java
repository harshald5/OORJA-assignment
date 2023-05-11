package com.oorjaa.ShopApp.Service;


import java.util.List;
import com.oorjaa.ShopApp.Model.Products;


public interface ProductsService {
	
	public void saveProducts(Products products);
	public List<Products> allproduct();
	public Products getProductById(int id);

}
