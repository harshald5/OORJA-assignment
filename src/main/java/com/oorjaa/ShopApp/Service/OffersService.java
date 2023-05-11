package com.oorjaa.ShopApp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oorjaa.ShopApp.Model.Offers;


public interface OffersService {
	
	public void addOffer(Offers offers);
	
	public List<Offers> showAllOffers();
	
	public Offers getByOfferCode(String offerCode);

	public void updateOffer(Offers offers);

}
