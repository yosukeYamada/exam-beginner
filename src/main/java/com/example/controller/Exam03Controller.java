package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	private static final double tax = 1.1;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("/buy")
	public String buy(Integer item1, Integer item2, Integer item3) {
		int totalPrice = item1 + item2 + item3;
		int totalPriceWithTax = (int)(totalPrice * tax);
		application.setAttribute("totalPrice", totalPrice);
		application.setAttribute("totalPriceWithTax", totalPriceWithTax);		
		return "exam03-result";
	}

}
