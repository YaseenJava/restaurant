package com.fastfood.restaurants.payment;

//package com.fastfood.restaurants;

import org.json.JSONObject;

import com.fastfood.restaurants.Product;
import com.fastfood.restaurants.customer.Customer;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import org.springframework.beans.factory.annotation.Autowired;


public class PaymentIntegration {
	
	@Autowired
	Customer cusOrder;
	private String razorpayKey="rzp_test_ogWSDJgUskpZhC";
	private String razorpaySecret="GQGX3iQ79OvZIPRq90YU9NQ7";
	
	void order(Customer cusOrder)  throws Exception{
		

	    JSONObject orderre=new JSONObject();
		orderre.put("amount",cusOrder.getProductPrice());
		orderre.put("currency","INR");
		orderre.put("receipt",cusOrder.getOrderd());
		RazorpayClient client=new RazorpayClient(razorpayKey,razorpaySecret);
		
		
		
		Order razorPayOrder =client.orders.create(orderre);
		System.out.print(razorPayOrder);
				
		//d.setRazorpayOrderId(razorPayOrder.get("id"));
	   // d.setOrderStatus(razorPayOrder.get("status"));
	//	donorRepo.save(d);
		
		
		
		
		
		
		
		
		
		
		
	}

}
