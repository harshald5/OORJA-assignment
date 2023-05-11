package com.oorjaa.ShopApp.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oorjaa.ShopApp.Model.Orders;
import com.oorjaa.ShopApp.Service.OrdersService;


@RequestMapping("/order")
@RestController
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	//TO ENABLE USER TO PLACE ORDER WITH AND WITHOUT OFFER CODE
	
	//1 --- Place order without offer code
	
	@PostMapping("/addorder") 
	public String createOrder(@RequestBody Orders orders) {
	
		return ordersService.saveOrder(orders);
	}
	
	//2 Placing order with offer Code
	
	@PostMapping("/addorder/{offerCode}") 
	public String Order(@RequestBody Orders orders, @PathVariable String offerCode) {
		
		return ordersService.saveOrderWithOffer(orders, offerCode);
			
	}
	
	@GetMapping("/getorderbyid/{id}")              //To get order details
	public Orders getOrderById(@PathVariable int id)
	{
		return ordersService.getById(id);
	}
	
	@PutMapping("/{status}/{oid}")                 // to update order status by admin
	public String update(@PathVariable String status,@PathVariable int oid)
	{
		
		return ordersService.updateStatus(status, oid);
	}
	
	
	
	
	
}
