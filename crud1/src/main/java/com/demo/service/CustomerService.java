package com.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Component;

import com.demo.bo.CustomerBo;
import com.demo.entity.Customer;

@Component

public class CustomerService {
	@Autowired
	
	CustomerBo serviceBO;
	
	public Customer insertServiceCustomer(Customer addCustomer) {
		return serviceBO.insertCustomer(addCustomer);
	}
	
	public Customer findServiceCustomer(Integer id) {
		return  serviceBO.findCustomer(id);
		
		}
	
	public List<Customer> findAllServiceCustomer(){
		return serviceBO.findAllCustomer();
	}
	
	public List<Customer> findAllOrderByNameDescending(){
		return serviceBO.findAllOrderByNameDescending();

	}
		
	@Autowired
	CustomerBo bo1;
	/*public Customer updateServiceCustomer(Customer upCustomer) {
			return serviceBO.updateCustomer(upCustomer);	
	}}
	
	/*@Autowired
	CustomerBo serviceBo; 
	
	@Autowired
	StockBo  bo2;
	
	@Autowired
	CustomerBo bo1;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transactionDemo(Customer c,Stock cl) {
		System.out.println("Customer Add-----Before");
		bo1.insertCustomer(c);
		System.out.println("CustomerBo Add-----After");
		System.out.println("StockBo Add-----Before");
		bo2.insertStock(cl);
		System.out.println("StockBo Add-----After");
	}
	
	//Custom queries
	public List<Customer> filterById(int id)
	{
		return bo1.filterById(id);
	}*/
	
	public List<Customer> filterByName(String name)
	{
		return filterByName(name);
	}

public List<Customer> filterById(int id)
{
	return bo1.filterById(id);
}
}	
	/*public List<CustomerCustomized> filterByNameCustomized(String name)
	{
		return bo1.filterByNameCustomized(name);*/
	
	
	/*public List<Customer> findAllOrderByNameDescending()
	{
		return bo1.findAllOrderByNameDescending();
	}
	
	//Inner Join
	/*public List <Customer> findCredWithPers()
	{
		return bo1.findCredWithPers();
	}*/
	
	//Left Join
	/*public List<Customer> findCredWithPersLeft()
	{
		return bo1.findCustomerWithPersLeft();
	}
	
	//customized data by join
	public List <CustomerCustomized> findCredWithPersCust()
	{
		return bo1.findCustomerWithPersCust();
	}
}*/