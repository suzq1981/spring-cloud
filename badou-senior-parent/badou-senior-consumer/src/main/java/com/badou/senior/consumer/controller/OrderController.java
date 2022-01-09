package com.badou.senior.consumer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badou.senior.consumer.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	@GetMapping("/{id}")
	public Order get(@PathVariable Integer id) {
		Order order = Order.builder().id(1).orderSeq("90081103").build();
		return order;
	}

	@PostMapping
	public Order post(@RequestBody Order order) {
		return order;
	}

	@GetMapping("/qry")
	public List<Order> qry(Integer age, String name) {
		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.builder().id(1).orderSeq("9880983").build());
		orders.add(Order.builder().id(2).orderSeq("9880984").build());
		orders.add(Order.builder().id(3).orderSeq("9880985").build());

		return orders;
	}

}
