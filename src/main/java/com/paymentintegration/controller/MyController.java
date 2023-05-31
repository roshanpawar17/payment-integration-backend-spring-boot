package com.paymentintegration.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.*;

import com.paymentintegration.model.Amount;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MyController {
	
	@PostMapping("/getamount")
	public String getAmount(@RequestBody Amount amt) throws RazorpayException {
		int amount=amt.getAmount();
//		System.out.print(amount);

		
		RazorpayClient client=new RazorpayClient("rzp_test_Q9o2CX6JIomOP9", "8ZqkZp8QdIeEPjUdac0O3n9Z");
		
			  JSONObject orderRequest = new JSONObject();
			  orderRequest.put("amount", amount*100); 
			  orderRequest.put("currency", "INR");
			  orderRequest.put("receipt", "order_rcptid_11");

			  //create new order
			  Order order = client.orders.create(orderRequest);
//			  System.out.print(order);
			  
		
		return order.toString();
		
	}
}
