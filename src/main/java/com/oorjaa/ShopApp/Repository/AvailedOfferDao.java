package com.oorjaa.ShopApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oorjaa.ShopApp.Model.AvailedOffer;

@Repository
public interface AvailedOfferDao extends JpaRepository<AvailedOffer,Integer>{
	public List<AvailedOffer> findByCid(int id);

}
