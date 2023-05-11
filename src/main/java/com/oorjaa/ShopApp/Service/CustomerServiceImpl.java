package com.oorjaa.ShopApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.oorjaa.ShopApp.Model.Customer;
import com.oorjaa.ShopApp.Repository.CustomerDao;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao ;
	

	@Override
	public void saveUser(Customer customer) {
		customerDao.save(customer);
		
	}

}
