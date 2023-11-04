package com.demo.bo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.dao.*;
import com.demo.entity.*;


@Component
public class StockBo {
	
	@Autowired
	StockRepository reStock;

	public  Stock insertStock(Stock addStock) {
		return reStock.save(addStock);
		
	}
		
	public Stock findStock(Integer id) {
		Optional<Stock> clm = reStock.findById(id);
		return clm.get();
		}
	
	public List<Stock> findAllStock(){
		return reStock.findAll();
	}
		
	public Stock updateStock(Stock upStock) {
			return reStock.save(upStock);	
	}

}