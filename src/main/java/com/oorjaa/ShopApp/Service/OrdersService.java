package com.oorjaa.ShopApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.oorjaa.ShopApp.Model.Orders;



public interface OrdersService {
	
String saveOrder(Orders orders);
String saveOrderWithOffer(Orders orders ,String offerCode);
String updateStatus( String status, int oid);
Orders getById(int id);
}
