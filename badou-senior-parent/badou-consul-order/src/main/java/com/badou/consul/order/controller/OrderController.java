package com.badou.consul.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badou.consul.order.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	@GetMapping("/{id}")
	public Order get(@PathVariable("id") Integer orderId) {
		return Order.builder().orderId(orderId).orderSeq("9007981220").build();
	}

}
