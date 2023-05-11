package com.oorjaa.ShopApp.Service;

import org.springframework.stereotype.Service;

import com.oorjaa.ShopApp.Model.Orders;



public interface OrdersService {
	
String saveOrder(Orders orders);
Orders getById(int id);
}
