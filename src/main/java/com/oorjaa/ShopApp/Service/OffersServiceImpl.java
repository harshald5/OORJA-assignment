package com.oorjaa.ShopApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oorjaa.ShopApp.Model.Offers;
import com.oorjaa.ShopApp.Repository.OffersDao;

@Service
public class OffersServiceImpl implements OffersService {

	@Autowired
	private OffersDao offersDao;
	
	@Override
	public void addOffer(Offers offers) {
		offersDao.save(offers);
	}

	@Override
	public List<Offers> showAllOffers() {
		return offersDao.findAll();
	}

	@Override
	public Offers getByOfferCode(String offerCode) {
		return offersDao.getByOfferCode(offerCode);
	}

	@Override
	public void updateOffer(Offers offers) {
		offersDao.save(offers);
		
	}

}
