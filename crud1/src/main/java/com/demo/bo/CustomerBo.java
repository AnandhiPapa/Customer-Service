package com.demo.bo;


import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.dao.*;
//import com.demo.dao.CustomerCustomized.CustomerEntityCustomized;
import com.demo.entity.*;
import com.demo.exception.CustomerException;


@Component
public class CustomerBo {
	
	@Autowired
	 
	CustomerRepository reCustomer;
	Customer crud = new Customer();
	
public Customer insertCustomer(Customer addCustomer) {
		
		if(addCustomer.getName() == null || addCustomer.getName().isEmpty()) {
	        throw new CustomerException("Credential---> name cannot be empty.");
	    }
		return reCustomer.save(addCustomer);
		
	}
		
	public Customer findCustomer(Integer id) {
		Optional<Customer> clm = reCustomer.findById(id);
		if(clm.isPresent()) {
			Customer c=clm.get();
			return c;
		}
		else {
			throw new CustomerException("Inappropriate Id");
		}
	}
	
	public List<Customer> findAllCustomer(){
		if(crud==null) {
			throw new CustomerException("Null value not allowed");
		}
		return reCustomer.findAll();
	}

	public Customer updateCustomer(Customer updateCustomer) {
		if(updateCustomer.getId()>=10) {
			throw new CustomerException("Inappropriate Id");
		}
			return reCustomer.save(updateCustomer);	
	}
	public List<Customer> findAllOrderByNameDescending(){

		return reCustomer.findAllOrderByNameDescending();
	}

	public List<Customer> filterById(int id){
		return reCustomer.filterById(id);
	}

	//public List<Customer> findAllOrderByNameDescending()
	//{
		//return reCustomer.findAllOrderByNameDescending();
	}
	

 //public Customer filterByName(String name) 
 //{ return reCustomer.filterByName(name); }}
 
	/*public List<CustomerCustomized> filterByNameCustomized(String name)
	{
		return reCustomer.filterByNameCustomized(name);*/
	
	/*
	 * //Inner Join public List <Customer> findCustomerWithPers() { return
	 * reCustomer.findCustomerWithPers(); }
	 */
	
	//Left Join
	/*public List<Customer> findCustomerWithPersLeft()
	{
		return reCustomer.findCustomerWithPersLeft();
	}
	
	//customized data by join
	public List<CustomerCustomized>findCustomerWithPersCust()
	{
		return reCustomer.findCustomerWithPersCust();
	}}*/
	
