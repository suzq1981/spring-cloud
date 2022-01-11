package com.badou.consul.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badou.consul.order.entity.Order;
import com.badou.consul.order.feign.UserFeignClient;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserFeignClient userServcie;

	@GetMapping("/{id}")
	public Order get(@PathVariable("id") Integer orderId) {
		System.out.println(userServcie.get(orderId));
		
		return Order.builder().orderId(orderId).orderSeq("9007981220").build();
	}

}
