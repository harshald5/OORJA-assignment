package com.oorjaa.ShopApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oorjaa.ShopApp.Model.Orders;
import com.oorjaa.ShopApp.Repository.OrdersDao;
@Service
public class OrderServiceImpl implements OrdersService{
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public String saveOrder(Orders orders) {
		ordersDao.save(orders);
		return "order placed successfully!!!";
		
	}

	@Override
	public Orders getById(int id) {
		// TODO Auto-generated method stub
		return ordersDao.findById(id).orElse(null);
	}

}
