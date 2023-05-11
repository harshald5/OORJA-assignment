package com.oorjaa.ShopApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oorjaa.ShopApp.Model.Offers;
import com.oorjaa.ShopApp.Service.OffersService;
import com.oorjaa.ShopApp.Service.OffersServiceImpl;

import jakarta.annotation.PostConstruct;

@RequestMapping("/offer")
@RestController
public class OffersController {
	@Autowired
	private OffersService offersService;
	
	//To display offers
	@GetMapping("/showAll")
	public List<Offers> getAllOffers()
	{
		return offersService.showAllOffers();
	}
	
	//To add offer
	@PostMapping("/addOffer")
	public String addOffer(@RequestBody Offers offers)
	{
		
		offersService.addOffer(offers);
		return "Offer Added!!";
	}
	
	//Update offer details
	@PutMapping("/updateoffer")
	public String updateoffer(@RequestBody Offers offers) 
	{
		offersService.updateOffer(offers);
		return "offer updated!!";
	}

}
