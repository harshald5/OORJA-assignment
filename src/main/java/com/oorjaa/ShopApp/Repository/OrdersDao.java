package com.oorjaa.ShopApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oorjaa.ShopApp.Model.Orders;
@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer>{

}
