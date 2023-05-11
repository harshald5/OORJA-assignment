package com.oorjaa.ShopApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oorjaa.ShopApp.Model.Products;
import com.oorjaa.ShopApp.Repository.ProductsDao;
@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsDao productsDao;

	@Override
	public void saveProducts(Products products) {
		productsDao.save(products);
	}

	@Override
	public List<Products> allproduct() {
		
		return productsDao.findAll();
	}

	@Override
	public Products getProductById(int id) {
		// TODO Auto-generated method stub
		return productsDao.findById(id).orElse(null);
	}

}
