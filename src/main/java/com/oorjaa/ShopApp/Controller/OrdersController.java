package com.oorjaa.ShopApp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oorjaa.ShopApp.Model.AvailedOffer;
import com.oorjaa.ShopApp.Model.Orders;
import com.oorjaa.ShopApp.Model.Products;
import com.oorjaa.ShopApp.Repository.AvailedOfferDao;
import com.oorjaa.ShopApp.Service.OffersService;
import com.oorjaa.ShopApp.Service.OrdersService;
import com.oorjaa.ShopApp.Service.ProductsService;


@RequestMapping("/order")
@RestController
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private AvailedOfferDao avl;
	
	@Autowired
	private ProductsService prodService;
	
	@Autowired
	private OffersService offersService;
	
	//TO ENABLE USER TO PLACE ORDER WITH AND WITHOUT OFFER CODE
	
	//1 --- Place order without offer code
	
	@PostMapping("/addorder") 
	public String createOrder(@RequestBody Orders orders) {
	
		if(!isWeekEnd(LocalDate.now()))
		{
		
			if(prodService.getProductById(orders.getProduct().getProductId()).getPrice()<5000 && prodService.getProductById(orders.getProduct().getProductId()).getPrice()>99 )
			{
				if(prodService.getProductById(orders.getProduct().getProductId()).getQty()>0)
				{
					Products prod=prodService.getProductById(orders.getProduct().getProductId()); //Logic for updating stocks
				    int qty=prod.getQty()-1;        // subtracting quantity from products
				    prod.setQty(qty);              // setting up updated quantity status
				    prodService.saveProducts(prod);// saving changed quantity wise data
				    orders.setValue(prod.getPrice());
				    return ordersService.saveOrder(orders); // PLACING ORDER
				}
				else
				{
					return "Out Of Stock";
				}
			}
			else
			{
				return "Minimum Order value must be 100 and max must be 4999";
			}
		}
		else
		{
			return "We dont take orders on Weekends";
		}
	}
	
	//2 Placing order with offer Code
	
	@PostMapping("/addorder/{offerCode}") 
	public String Order(@RequestBody Orders orders, @PathVariable String offerCode) {
		
		String []presentdate=LocalDate.now().toString().split("-");
		String []offdate=offersService.getByOfferCode(offerCode).getValidity().toString().split("-");
		
		if(Integer.parseInt(offdate[0])<Integer.parseInt(presentdate[0]))// checking year
		{
			return "Coupon code is expired"; 
		}
		else if(Integer.parseInt(offdate[0])==Integer.parseInt(presentdate[0]) && (Integer.parseInt(offdate[1])<Integer.parseInt(presentdate[1])) )
		{
			return "Coupon code is expired";
		}
		else if(Integer.parseInt(offdate[0])==Integer.parseInt(presentdate[0]) && (Integer.parseInt(offdate[1])==Integer.parseInt(presentdate[1])) && (Integer.parseInt(offdate[2])<Integer.parseInt(presentdate[2])))
		{
			return "Coupon code is expired";
		}
		
		boolean flag = false;
		List <AvailedOffer> list = avl.findByCid(orders.getCustomer().getCustId());//List of customer who has availed the offer
		for(AvailedOffer each : list) //iterating list of customer who has availed offers
		{
			String availed = each.getOfferidcid().toString();// offeridcid is offer code
			String applied = offerCode.toString();
			if(availed.equals(applied))
			{
				flag = true;
				break;
			}
			
		}
		if(flag)
		{
			return "Offer is already availed";
		}
		if(!isWeekEnd(LocalDate.now()))
		{
		
			if(prodService.getProductById(orders.getProduct().getProductId()).getPrice()<5000 || prodService.getProductById(orders.getProduct().getProductId()).getPrice()>99 )
			{
				
				
					if(offersService.getByOfferCode(offerCode).getAmount()< prodService.getProductById(orders.getProduct().getProductId()).getPrice()) // ensuring user offer amount is less than product price
					{
						if(prodService.getProductById(orders.getProduct().getProductId()).getQty()>0) // checking stocks
						{
						
						Products prod=prodService.getProductById(orders.getProduct().getProductId());
						int qty=prod.getQty()-1;           // subtracting qty from products======this logic need to be improved
					    prod.setQty(qty);                  // setting up updated qty status
						prodService.saveProducts(prod);    // saving changed qty wise data
						
						//For availed offer table
						AvailedOffer ao = new AvailedOffer(); // to save the customer details who has already applied offer
						String oc=offerCode;
						ao.setOfferidcid(oc);                // setting offer code acc to cid
						ao.setCid(orders.getCustomer().getCustId()); // getting cid
						avl.save(ao);                        //saving it to availed offer table
						
						//To get reduced price data
						orders.setValue(prod.getPrice() - offersService.getByOfferCode(offerCode).getAmount());
						return ordersService.saveOrder(orders); // placing order
						}
						else
						{
							return "Out Of Stock";
						}
					}
					else
					{
						return "applicable on products above "+ offersService.getByOfferCode(offerCode).getAmount()+" rupees only!!";
					}
				
			}
			else
			{
				return "Minimum Order value must be 100 and max must be 4999";
			}
		}
		else
		{
			return "We dont take orders on Weekends";
		}
	}
	
	@GetMapping("/getorderbyid/{id}")              //To get order details
	public Orders getOrderById(@PathVariable int id)
	{
		return ordersService.getById(id);
	}
	
	@PutMapping("/{status}/{oid}")                 // to update order status by admin
	public String update(@PathVariable String status,@PathVariable int oid)
	{
		Orders orders = ordersService.getById(oid);
		orders.setStatus(status);
		ordersService.saveOrder(orders);
		return "Order Status updated successfully!!";
	}
	
	
	
	//Method to check weekend
	
	 public static boolean isWeekEnd(LocalDate localDate)
	    {
	        String dayOfWeek = localDate.getDayOfWeek().toString();
	        if("SATURDAY".equalsIgnoreCase(dayOfWeek)||
	        "SUNDAY".equalsIgnoreCase(dayOfWeek))
	        {
	            return true;
	        }
	        return false;
	    }
	
}
