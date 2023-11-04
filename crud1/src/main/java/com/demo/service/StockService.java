package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.*;
import com.demo.entity.*;

@Component
public class StockService {
	
	@Autowired
	StockBo servicesBO;
	
	public Stock insertServiceStock(Stock addStock) {
		return servicesBO.insertStock(addStock);
	}
	
	public Stock findServiceStock(Integer id) {
		return  servicesBO.findStock(id);
		
		}
	
	public List<Stock> findAllServiceStock(){
		return servicesBO.findAllStock();
	}
		
	public Stock updateServiceClaim(Stock upStock) {
			return servicesBO.updateStock(upStock);	
	}

}
//Stock service