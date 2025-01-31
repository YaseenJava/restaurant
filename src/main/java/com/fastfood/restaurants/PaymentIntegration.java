package com.fastfood.restaurants;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;

public class PaymentIntegration {
	
	@Autowired
	Product product;
	private String razorpayKey="rzp_test_ogWSDJgUskpZhC";
	private String razorpaySecret="GQGX3iQ79OvZIPRq90YU9NQ7";
	
	void order(Product product)  throws Exception{
		

	    JSONObject orderre=new JSONObject();
		orderre.put("amount",product.getPrice()*100);
		orderre.put("currency","INR");
		orderre.put("receipt",product.getId());
		RazorpayClient client=new RazorpayClient(razorpayKey,razorpaySecret);
		
		
		
		Order razorPayOrder =client.orders.create(orderre);
		System.out.print(razorPayOrder);
				
		//d.setRazorpayOrderId(razorPayOrder.get("id"));
	   // d.setOrderStatus(razorPayOrder.get("status"));
	//	donorRepo.save(d);
		
		
		
		
		
		
		
		
		
		
		
	}

}
