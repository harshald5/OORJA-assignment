package com.oorjaa.ShopApp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oorjaa.ShopApp.Model.Customer;



@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{

	
}
