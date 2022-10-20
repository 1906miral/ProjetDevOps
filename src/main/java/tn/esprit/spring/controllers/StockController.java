package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.IStockService;

@RestController
public class StockController {
  @Autowired
  IStockService stockService;
  @GetMapping("/retrieveStatusStock")
  @ResponseBody
	public String retrieveStatusStock(){
	  
		return stockService.retrieveStatusStock();
	}

}
